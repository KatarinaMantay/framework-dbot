package dev.kataray.discord.filter;

import dev.jsinco.discord.framework.events.ListenerModule;
import dev.jsinco.discord.framework.logging.FrameWorkLogger;
import dev.kataray.discord.openai.OpenAIManager;
import io.github.stefanbratanov.jvm.openai.*;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.util.List;

public class OpenAiChatFilterModule implements ListenerModule {


    // listen for message received. Make sure the message is from a guild. Ask openai if there is a naughty word in the message. and ask it to return a boolean

    private static final String PRE_APPEND = "Is there a bad word in this message? Return either true or false:\n";

    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild() || event.getAuthor().isBot()) {
            return;
        }

        ChatClient client = OpenAIManager.getInstance().getChatClient();

        CreateChatCompletionRequest request = CreateChatCompletionRequest.newBuilder()
                .model(OpenAIModel.GPT_4o)
                .message(ChatMessage.userMessage(PRE_APPEND + event.getMessage().getContentRaw()))
                .build();

        ChatCompletion chatCompletion = client.createChatCompletion(request);
        List<ChatCompletion.Choice> choices = chatCompletion.choices();

        boolean isBadWord = false;


        for (ChatCompletion.Choice choice : choices) {
            ChatCompletion.Choice.Message response = choice.message();

            if (response.refusal() != null) {
                FrameWorkLogger.info("Open AI refused to respond: " + response.refusal());
                return;
            }

            // get a boolean from our content. If we're unable to parse a boolean from our content, fail and return. (Boolean#parseBoolean)

            if (Boolean.parseBoolean(response.content().toLowerCase())) {
                isBadWord = true;
                break;
            }
        }

        if (!isBadWord) {
            return;
        }

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();

        channel.sendMessage("You can't say that word! <@" + message.getAuthor().getId() + ">").queue();
        message.delete().queue();
    }
}
