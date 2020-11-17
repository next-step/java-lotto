package step01;

public class Blank {
    private static String EMPTY = "";

    public static boolean isNull(String input) {
        return input == null;
    }

    public static boolean isEmpty(String input) {
        return input.trim() == EMPTY;
    }

    public static boolean validate(String input) {
        return isNull(input) || isEmpty(input);
    }
}
