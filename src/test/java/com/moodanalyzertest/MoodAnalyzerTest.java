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
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        MoodAnalyzer moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser();
        Assert.assertEquals(true,moodAnalyzer.equals(moodAnalyserFactory));
    }

    @Test
    public void givenMoodAnalyser_WhenClassNameNotProper_ShouldReturnClassNotFound(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            MoodAnalyzer moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser();
            Assert.assertEquals(true, moodAnalyzer.equals(moodAnalyserFactory));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }
}
