package step1.utils;

public class StringSpliter {

    public static final String DELIMETER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static String[] spliter(String delimiter, String group) {
        return checkSplitedString(group.split(delimiter));
    }

    private static String[] checkSplitedString(String[] inputStrings) {
        for (String inputString : inputStrings) {
            if (inputString == null) {
                throw new RuntimeException();
            }

            if (inputString.isEmpty()) {
                throw new RuntimeException();
            }

            if (Integer.parseInt(inputString) < 0) {
                throw new RuntimeException();
            }
        }

        return inputStrings;
    }
}
