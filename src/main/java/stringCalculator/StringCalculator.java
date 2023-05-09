package stringCalculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private final List<String> inputs;

    public StringCalculator(String text) {
        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백입니다");
        }
        this.inputs = Arrays.asList(text.split(" "));
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public int calculate() {
        Value result = new Value(Integer.parseInt(inputs.get(0)));
        for (int i = 1; i < inputs.size() - 2; i += 2) {
            result = new Value(calculateNext(i, result));
        }
        return calculateNext(inputs.size() - 2, result);
    }

    private int calculateNext(int index, Value value) {
        FourArithmeticOperator operator = FourArithmeticOperator.fromSymbol(inputs.get(index));
        if (operator != null) {
            int operand = Integer.parseInt(inputs.get(index + 1));
            return operator.operate(value, operand);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
    }
}
