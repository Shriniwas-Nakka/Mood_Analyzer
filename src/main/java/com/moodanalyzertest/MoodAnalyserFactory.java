package com.moodanalyzertest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyser() throws MoodAnalysisException {
        try {
            Class<?> moodanalyserClass = Class.forName("com.moodanalyzertest.MoodAnalyzer");
            Constructor<?> moodConstructor = moodanalyserClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Class Not Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Method Not Found");
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
