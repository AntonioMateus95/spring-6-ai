package guru.springframework.spring6ai.services;

import guru.springframework.spring6ai.models.Answer;
import guru.springframework.spring6ai.models.Question;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);
}
