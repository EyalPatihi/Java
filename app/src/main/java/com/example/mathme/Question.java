package com.example.mathme;

public class Question
{
    // answerResId will store question
    int question;

    // answerTrue will store correct answer of the question provided
    boolean answerTrue;

    public Question(int question, boolean answerTrue)    {
        // Setting the values through arguments passed in constructor
        this.question = question;
        this.answerTrue = answerTrue;
    }

    // Returning the question passed
    public int getQuestion() {
        return question;
    }

    // Setting the question passed
    public void setQuestion(int question) {
        this.question = question;
    }

    // Returning the correct answer of question
    public boolean isAnswerTrue()   {
        return answerTrue;
    }

    // Setting the correct answer of question
    public void setAnswerTrue(boolean answerTrue)   {
        this.answerTrue = answerTrue;
    }
}
