package com.moodanalyzertest;

public class MoodAnalysisException extends Exception {

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS,NO_ACCESS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public MoodAnalysisException( ExceptionType type, String s, Throwable throwable) {
        super(s, throwable);
        this.type = type;
    }

    public MoodAnalysisException( ExceptionType type, Throwable throwable) {
        super(throwable);
        this.type = type;
    }
}
