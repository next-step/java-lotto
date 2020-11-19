public class StringAddCalculator {
    private final static String COMMA = ",";

    public Integer add(String input) {
        if (isEmptyValue(input)) {
            return 0;
        }

        if (isSingleNumber(input)) {
            return Integer.parseInt(input);
        }

        if (input.contains(COMMA)) {
            String[] numbers = input.split(COMMA);
            return getSum(numbers);
        }
        return null;
    }

    private int getSum(String[] split) {
        int result = 0;
        for (String s: split) {
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
