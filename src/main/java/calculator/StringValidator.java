package calculator;

public class StringValidator {

    private static String value;

    public static int check(String input) {
        value = input;
        return (isNull() || isEmpty()) ?0:1;
    }

    private static boolean isNull() {
        return value == null;
    }

    private static boolean isEmpty() {
        return value.isEmpty();
    }
}
