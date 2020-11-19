public class StringAddCalculator {
    private final static String COMMA = ",";
    private final static String COLON = ":";
    private final static String DELIMITER = ",|:";

    public Integer add(String input) {
        if (isEmptyValue(input)) {
            return 0;
        }

        if (isSingleNumber(input)) {
            return Integer.parseInt(input);
        }

        if (containsDelimiter(input)) {
            String[] numbers = input.split(DELIMITER);
            return getSum(numbers);
        }
        return null;
    }

    private boolean containsDelimiter(String input) {
        return input.contains(COMMA) || input.contains(COLON);
    }

    private int getSum(String[] split) {
        int result = 0;
        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    private boolean isSingleNumber(String input) {
        return input.length() == 1;
    }

    private boolean isEmptyValue(String input) {
        return input == null || input.isEmpty();
    }
}
