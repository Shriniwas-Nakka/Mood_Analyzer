package com.moodanalyzertest;

public class MoodAnalyzer {
    private String message=null;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public MoodAnalyzer() {

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

    public boolean equals(MoodAnalyzer another) {
        if (this.message == (another.message))
            return true;
        return false;
    }
}
