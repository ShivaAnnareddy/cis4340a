package main;

import java.lang.reflect.Constructor;

public class ExceptionThrower {

    private static Throwable currentThrowable;

    private ExceptionThrower() throws Throwable {
        throw currentThrowable;
    }

    public static synchronized void triggerException(Throwable throwable) {
        checkAndThrowIllegalArgumentException(throwable);
        currentThrowable = throwable;
        try {
            instantiateAndThrow();
        } finally {
            currentThrowable = null; // Ensure throwable is cleared after use
        }
    }

    private static void checkAndThrowIllegalArgumentException(Throwable throwable) {
        if (throwable instanceof IllegalAccessException || throwable instanceof InstantiationException) {
            throw new IllegalArgumentException("Illegal access or instantiation exception");
        }
    }

    private static void instantiateAndThrow() {
        try {
            Constructor<ExceptionThrower> constructor = ExceptionThrower.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException ignored) {
            // These exceptions indicate a programming error and should not occur
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw new RuntimeException("Unexpected checked exception", cause);
            }
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionThrower.triggerException(new Exception("Simulate any checked exception"));
        } catch (RuntimeException e) {
            System.err.println("Exception propagated: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
