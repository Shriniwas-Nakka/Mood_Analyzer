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
    public void givenMessage_WhenEmpty_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Please enter proper message");
        try {
            String mood = moodAnalyzer.analyzeMood("");
            Assert.assertEquals("Please enter proper message", mood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter proper message", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createMoodAnalyser();
        Assert.assertEquals(true,moodAnalyzer.equals(moodAnalyserFactory));
    }

    @Test
    public void givenMoodAnalyser_WhenClassNameNotProper_ShouldReturnClassNotFound(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createMoodAnalyser();
            Assert.assertEquals(true, moodAnalyzer.equals(moodAnalyserFactory));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenConstructorNotProper_ShouldReturnMethodNotFound(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createMoodAnalyser();
            Assert.assertEquals(true, moodAnalyzer.equals(moodAnalyserFactory));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserWithString_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("SAD");
        MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createStringMoodAnalyser("SAD");
        Assert.assertEquals(true,moodAnalyzer.equals(moodAnalyserFactory));
    }

    @Test
    public void givenMoodAnalyserWithString_WhenClassNameNotProper_ShouldReturnClassNotFound(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Class Not Found");
            MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createStringMoodAnalyser("Class Not Found");
            Assert.assertEquals(true, moodAnalyzer.equals(moodAnalyserFactory));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserWithString_WhenConstructorNotProper_ShouldReturnMethodNotFound(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Method Not Found");
            MoodAnalyzer moodAnalyserFactory = MoodAnalyserReflector.createStringMoodAnalyser("Method Not Found");
            Assert.assertEquals(true, moodAnalyzer.equals(moodAnalyserFactory));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy() throws MoodAnalysisException {
        Object moodObj = null;
        try {
            moodObj = MoodAnalyserReflector.createStringMoodAnalyser("I am in a Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(moodObj, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() {
        try {
            Object moodObj = MoodAnalyserReflector.createStringMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue(moodObj, "message", "I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(moodObj, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}