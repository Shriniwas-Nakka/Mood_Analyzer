package com.moodanalyzertest;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {
       try {
           if (message.length() == 0)
               throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please enter proper message");
           if (message.contains("I am in sad Mood"))
               return "SAD";
           else
               return "HAPPY";
       } catch (NullPointerException e) {
           throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please enter proper message");
       }
    }

    public String analyzeMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyzeMood();
    }

    public boolean equals(Object another) {
        if (this.message.equals(((MoodAnalyzer)another).message))
            return true;
        return false;
    }
}
