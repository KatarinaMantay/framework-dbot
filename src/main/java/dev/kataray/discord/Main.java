package dev.kataray.discord;

import dev.jsinco.discord.framework.FrameWork;
import dev.jsinco.discord.framework.console.ConsoleCommandManager;
import dev.kataray.discord.commands.TestCommand;
import dev.kataray.discord.openai.OpenAIManager;
import io.github.stefanbratanov.jvm.openai.*;

public class Main {

    public static void main(String[] args) {

        //ChatClient client = OpenAIManager.getInstance().getChatClient();
        //
        //        CreateChatCompletionRequest request = CreateChatCompletionRequest.newBuilder()
        //                .model(OpenAIModel.GPT_4o)
        //                .message(ChatMessage.userMessage("Is there a bad word in this message? Return either true or false:\n 'fuck you'"))
        //                .build();
        //
        //        ChatCompletion chatCompletion = client.createChatCompletion(request);
        //System.out.println(chatCompletion.choices());

        FrameWork.start(Main.class);

        ConsoleCommandManager.getInstance()
                .registerCommand(new TestCommand());
    }
}
