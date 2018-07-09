package com.example.tspc.quizsimulator;

/**
 * Created by ts pc on 2/27/2018.
 */

public class QuestionAnswer {
    private int questionId;
    private Boolean answer;

    public QuestionAnswer(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
