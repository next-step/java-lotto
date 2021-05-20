package study;

public class ConcatCalculator implements Calculator {
    private final String input;
    private final int minValue;

    public ConcatCalculator(String input, int minValue) {
        this.input = input;
        this.minValue = minValue;
    }

    public int calculate() {
        if (isUnusable()) {
            return minValue;
        }

        return stringToInt(input);
    }

    private boolean isUnusable() {
        return isNull() || isEmpty();
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }

    private int stringToInt(String input) {
        StringBuilder sb = new StringBuilder();
        for (String stringNumber : Splitter.split(input)) {
            sb.append(stringNumber);
        }
        return toValueGreaterThanMinValue(parseInt(sb.toString()));
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값을 넣을 수 없습니다.");
        }
    }

    private int toValueGreaterThanMinValue(int value) {
        if (isLessThanMinValue(value)) {
            throw new RuntimeException("최소값 보다 작은 값은 더할 수 없습니다.");
        }
        return value;
    }

    private boolean isLessThanMinValue(int value) {
        return value < minValue;
    }
}
