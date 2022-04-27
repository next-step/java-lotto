package stringcalculator;


import java.util.Objects;

public class StringCalculator {

    public static final int LAST_CONDITION = 3;

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int calculate(String input) {
        validate(input);
        Items items = new Items(ExtractFormula.splitText(input));
        return calculate(items);
    }

    private static void validate(String input) {
        Objects.requireNonNull(input, "입력값은 null 일 수 없습니다.");
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    private static int calculate(Items items) {
        int result = getResult(items);
        if (items.size() == LAST_CONDITION) {
            return result;
        }
        return calculate(Items.of(result, items));
    }

    private static int getResult(Items items) {
        int baseNumber = items.getFirstOperand();
        int targetNumber = items.getSecondOperand();
        return OperatorFactory.get(items.getOperator()).calculate(baseNumber, targetNumber);
    }
}
