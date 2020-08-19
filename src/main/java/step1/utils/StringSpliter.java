package step1.utils;

public class StringSpliter {

    private StringSpliter() {}

    public static String[] spliter(String delimiter, String group) {
        return checkSplitedString(group.split(delimiter));
    }

    private static String[] checkSplitedString(String[] inputStrings) {
        for (String inputString : inputStrings) {
            inputValueValidator(inputString);
        }

        return inputStrings;
    }

    private static void inputValueValidator(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new RuntimeException();
        }

        if (Integer.parseInt(inputString) < 0) {
            throw new NumberFormatException();
        }
    }
}
