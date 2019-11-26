package com.moodanalyzertest;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {
       try {
           if (message.contains("I am in sad Mood"))
               return "SAD";
           else
               return "HAPPY";
       } catch (NullPointerException e) {
           throw new MoodAnalysisException("Please enter proper message");
       }
    }

    public String analyzeMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyzeMood();
    }
}
