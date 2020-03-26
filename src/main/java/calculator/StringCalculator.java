package calculator;

public class StringCalculator {
    private static final String EMPTY_STRING = "";
    private static final int ZERO = 0;

    public int calculate(final String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        String[] splitInput = Delimiter.split(input);
        return add(splitInput);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || EMPTY_STRING.equals(input.trim());
    }

    private int add(final String[] splitInput) {
        int sum = ZERO;
        for (String letter : splitInput) {
            int parseNumber = parse(letter);
            checkNegative(parseNumber);
            sum += parseNumber;
        }
        return sum;
    }

    private int parse(String letter) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(letter);
        } catch (NumberFormatException ne) {
            throw new RuntimeException("숫자로 변환 할 수 없습니다.");
        }
        return parseInt;
    }

    private void checkNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException("음수 입니다.");
        }
    }
}
