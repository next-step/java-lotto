package stringaddcalculator;

public class StringAddCalculator {

    private final StringSeparator stringSeparator;

    public StringAddCalculator(StringSeparator stringSeparator) {
        this.stringSeparator = stringSeparator;
    }

    public Integer add(String input) {
        if (isEmptyValue(input)) {
            return 0;
        }

        if (isSingleNumber(input)) {
            return Integer.parseInt(input);
        }

        return getSum(stringSeparator.split(input));
    }

    private int getSum(String[] split) {
        int result = 0;
        for (String s : split) {
            int i = Integer.parseInt(s);
            validate(i);
            result += i;
        }
        return result;
    }

    private void validate(int i) {
        if (i < 0) throw new RuntimeException("양수만 입력 가능합니다 :)");
    }

    private boolean isSingleNumber(String input) {
        return input.length() == 1;
    }

    private boolean isEmptyValue(String input) {
        return input == null || input.isEmpty();
    }
}
