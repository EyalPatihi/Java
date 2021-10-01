package com.example.mathme;

public class Question
{
    // answerResId will store question
    private int answerResId;

    // answerTrue will store correct answer of the question provided
    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue)    {
        // Setting the values through arguments passed in constructor
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    // Returning the question passed
    public int getAnswerResId() {
        return answerResId;
    }

    // Setting the question passed
    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
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
