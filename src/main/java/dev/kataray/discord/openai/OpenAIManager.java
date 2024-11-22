package dev.kataray.discord.openai;

import dev.kataray.discord.util.Util;
import io.github.stefanbratanov.jvm.openai.ChatClient;
import io.github.stefanbratanov.jvm.openai.OpenAI;

public class OpenAIManager {

    // static field for our key
    private static final String OPENAI_API_KEY = Util.getFromEnvironment("open_ai_key");
    private static OpenAIManager instance;



    // youll need an instance of 'OpenAI'
    // you'll need to create an instance of this in your constructor
    // and the variable should be a field belonging to the class


    // make a method that gives me an instance of ChatClient


    private final OpenAI openAI;

    public OpenAIManager() {
        this.openAI = OpenAI.newBuilder(OPENAI_API_KEY).build();
    }

    public ChatClient getChatClient() {
        return openAI.chatClient();
    }


    public OpenAI getOpenAI() {
        return openAI;
    }

    public static OpenAIManager getInstance() {
        if (instance == null) {
            instance = new OpenAIManager();
        }
        return instance;
    }

}
