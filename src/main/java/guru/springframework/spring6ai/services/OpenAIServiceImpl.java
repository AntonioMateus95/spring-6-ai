package guru.springframework.spring6ai.services;

import guru.springframework.spring6ai.models.Answer;
import guru.springframework.spring6ai.models.GetCapitalRequest;
import guru.springframework.spring6ai.models.Question;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    public OpenAIServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Value("classpath:templates/get_capital_prompt.st")
    private Resource getCapitalPrompt;

    @Value("classpath:templates/get_capital_with_info.st")
    private Resource getCapitalPromptWithInfo;

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.call(prompt);

        return response.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        return new Answer(question.question());
    }

    @Override
    public Answer getCapital(GetCapitalRequest capitalRequest) {
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("country", capitalRequest.country()));
        ChatResponse response = chatClient.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }

    @Override
    public Answer getCapitalWithInfo(GetCapitalRequest capitalRequest) {
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPromptWithInfo);
        Prompt prompt = promptTemplate.create(Map.of("country", capitalRequest.country()));
        ChatResponse response = chatClient.call(prompt);

        return new Answer(response.getResult().getOutput().getContent());
    }
}
