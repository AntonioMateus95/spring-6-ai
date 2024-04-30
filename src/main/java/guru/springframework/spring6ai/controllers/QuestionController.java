package guru.springframework.spring6ai.controllers;

import guru.springframework.spring6ai.models.Answer;
import guru.springframework.spring6ai.models.GetCapitalRequest;
import guru.springframework.spring6ai.models.Question;
import guru.springframework.spring6ai.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }

    @PostMapping("/capital")
    public Answer getCapital(@RequestBody GetCapitalRequest capitalRequest) {
        return openAIService.getCapital(capitalRequest);
    }

    @PostMapping("/capitalWithInfo")
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest capitalRequest) {
        return openAIService.getCapitalWithInfo(capitalRequest);
    }
}
