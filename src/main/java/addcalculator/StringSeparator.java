package addcalculator;

public class StringSeparator {

    private static final String COMMA_OR_COLON = "[,:]";

    private StringSeparator() {
    }

    public static String[] separate(String text) {
        return text.split(COMMA_OR_COLON);
    }

    public static String[] separateFromCustomDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }
}
