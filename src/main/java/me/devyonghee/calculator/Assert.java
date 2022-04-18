package me.devyonghee.calculator;

final class Assert {

    private Assert() {
        throw new AssertionError();
    }

    static <T> void notNull(T object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    static void hasText(String text, String message) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
