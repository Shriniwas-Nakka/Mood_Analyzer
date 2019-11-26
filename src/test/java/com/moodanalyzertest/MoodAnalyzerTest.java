package com.moodanalyzertest;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String moodSad = moodAnalyzer.analyzeMood("I am in sad Mood");
        Assert.assertEquals("SAD", moodSad);
    }
}
