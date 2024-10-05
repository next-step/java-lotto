package calculator;

public class Splitter {
    private static final String BLANK = " ";

    private Splitter() {
    }

    public static String[] split(final String input) {
        return input.split(BLANK);
    }
}
