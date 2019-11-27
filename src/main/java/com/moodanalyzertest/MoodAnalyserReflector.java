package com.moodanalyzertest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyzer createMoodAnalyser(Constructor<?> constructor, Object ... message) throws MoodAnalysisException {
        try {
            return (MoodAnalyzer) constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE, e);
        }
    }
//    public static MoodAnalyzer createMoodAnalyser(Constructor<?> constructor, String s) throws MoodAnalysisException {
//        try {
//            Class<?> moodanalyserClass = Class.forName("com.moodanalyzertest.MoodAnalyzer");
//            Constructor<?> moodConstructor = moodanalyserClass.getConstructor();
//            Object moodObj = moodConstructor.newInstance();
//            return (MoodAnalyzer) moodObj;
//        } catch (ClassNotFoundException e) {
//            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Class Not Found");
//        } catch (NoSuchMethodException e) {
//            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method Not Found");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static MoodAnalyzer createStringMoodAnalyser(String message) throws MoodAnalysisException {
        try {
            Class<?> moodanalyserClass = Class.forName("com.moodanalyzertest.MoodAnalyzer");
            Constructor<?> moodConstructor = moodanalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Class Not Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method Not Found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObj, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyserObj.getClass().getMethod(methodName).invoke(moodAnalyserObj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not Found");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "No Access", e);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, "May be issues with values", e);
        }
    }

    public static void setFieldValue(Object moodObj, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = moodObj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodObj, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "Define proper field name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e);
        }
    }

    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodanalyserClass = Class.forName("com.moodanalyzertest.MoodAnalyzer");
            return moodanalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }
}
