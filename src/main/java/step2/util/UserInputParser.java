package step2.util;

public class UserInputParser {
    public static String[] impl(String input) {
        String newInput = input.replace(" ", "");
        return newInput.split(",");
    }
}
