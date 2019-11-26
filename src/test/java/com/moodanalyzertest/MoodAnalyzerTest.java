package com.moodanalyzertest;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad Mood");
        Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any Mood");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }

    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Please enter proper message");
        try {
            String mood = moodAnalyzer.analyzeMood(null);
            Assert.assertEquals("Please enter proper message", mood);
        } catch ( MoodAnalysisException e)
        {
            Assert.assertEquals("Please enter proper message", e.getMessage());
        }
    }

    @Test
<<<<<<< HEAD
    public void givenMessage_WhenEmpty_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Please enter proper message");
        try {
            String mood = moodAnalyzer.analyzeMood("");
            Assert.assertEquals("Please enter proper message", mood);
        } catch ( MoodAnalysisException e)
        {
            Assert.assertEquals("Please enter proper message", e.getMessage());
        }
=======
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("SAD");
        Assert.assertEquals(new MoodAnalyzer("SAD"), moodAnalyser);
>>>>>>> UC4_Reflection
    }
}
