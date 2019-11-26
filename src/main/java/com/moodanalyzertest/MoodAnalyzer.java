package com.moodanalyzertest;

public class MoodAnalyzer {

    public String analyzeMood(String message) {
        if (message.contains("I am in sad Mood"))
            return "SAD";
        else
            return "HAPPY";
    }
}
