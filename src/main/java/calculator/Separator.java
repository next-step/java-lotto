package calculator;

public class Separator {
    private static final String SEPARATOR = " ";

    public static String[] parser(String input) {
        return input.split(SEPARATOR);
    }
}
