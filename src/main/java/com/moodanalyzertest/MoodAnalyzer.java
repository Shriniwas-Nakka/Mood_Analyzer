package com.moodanalyzertest;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {
        if (message.contains("I am in sad Mood"))
            return "SAD";
        else
            return "HAPPY";
    }
}
