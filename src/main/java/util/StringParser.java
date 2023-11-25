package util;

public class StringParser {
    private StringParser() {
    }

    public static String[] parseWhiteSpace(String input) {
        return input.split(" ");
    }
    
    public static String[] parseComma(String input) {
        return input.split(", ");
    }
}
