package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculater {
    private static final String EMPTY_SPACE_PATTERN = "([0-9]+ . )+[0-9]";
    private static final String MUST_INCLUDE_EMPTY = "반드시 빈 공백이 포함되어야 합니다";
    private static final String MUST_NOT_NULL = "입력값은 NULL 이 될 수 없다";
    private static final String MUST_NOT_EMPTY = "입력값은 비어있을 수 없다";

    private Numbers numbers;
    private Operators operators;

    public Caculater(String input) {
        validation(input);
        numbers = new Numbers(input);
        operators = new Operators(input);
    }

    private void validation(String input) {
        if (input == null)
            throw new IllegalArgumentException(MUST_NOT_NULL);

        if (input.isEmpty())
            throw new IllegalArgumentException(MUST_NOT_EMPTY);

        if (!isInclueEmptySpace(input))
            throw new IllegalArgumentException(MUST_INCLUDE_EMPTY);
    }

    private boolean isInclueEmptySpace(String input) {
        return Pattern.compile(EMPTY_SPACE_PATTERN).matcher(input).matches();
    }

    private int calculation(int operand) {
        String operator = operators.peek();
        for (OperatorCaculate value : OperatorCaculate.values()) {
            if (operator.equals(value.getOperator())) {
                return OperatorCaculate.valueOf(value.name()).caclulate(operand, numbers.pick());
            }
        }
        return 0;
    }

    public int result() {
        int result = numbers.pick();
        while(numbers.isNotEmpty()) {
            result = calculation(result);
        }
        return result;
    }
}
