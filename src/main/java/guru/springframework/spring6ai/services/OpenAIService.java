package guru.springframework.spring6ai.services;

import guru.springframework.spring6ai.models.Answer;
import guru.springframework.spring6ai.models.GetCapitalRequest;
import guru.springframework.spring6ai.models.GetCapitalResponse;
import guru.springframework.spring6ai.models.Question;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest capitalRequest);

    Answer getCapitalWithInfo(GetCapitalRequest capitalRequest);
}
