package calculator;

public class Separator {
    private static final String SEPARATOR = " ";

    private Separator() {

    }

    public static String[] parser(String input) {
        return input.split(SEPARATOR);
    }
}
