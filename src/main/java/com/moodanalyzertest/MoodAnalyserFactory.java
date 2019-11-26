package com.moodanalyzertest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Class<?> moodanalyserClass = Class.forName("com.moodanalyzertest.MoodAnalyzer");
            Constructor<?> moodConstructor = moodanalyserClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
