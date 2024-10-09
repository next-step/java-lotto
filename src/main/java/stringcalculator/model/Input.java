package stringcalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Input {

    public static final String SPACE = " ";
    public static final String NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER = "잘못된 문자열을 입력했습니다.(공백 2개 이상, 숫자 연산자 숫자(2 * 3) 형태)";
    public static final int MIN_SIZE = 3;
    public static final int EVEN_CHECK_NUMBER = 2;
    public static final int ZERO = 0;
    public static final int FIRST_OPERAND_INDEX = 0;
    public static final int INDEX_INCREMENT = 2;
    public static final int OPERAND_OFFSET = 1;
    private final List<String> inputs;

    public Input(final String concatenatedInput) {
        this.inputs = split(concatenatedInput);
    }

    public static Input of(final String[] inputs) {
        return new Input(String.join(SPACE, inputs));
    }

    private List<String> split(final String input) {
        List<String> result = Arrays.asList(input.trim()
                .split(SPACE));

        if (isInvalidateSize(result.size())) {
            throw new IllegalArgumentException(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
        }

        return result;
    }

    private static boolean isInvalidateSize(int size) {
        return size < MIN_SIZE ||
                size % EVEN_CHECK_NUMBER == ZERO;
    }

    public Calculator convertToCalculator() {
        String firstOperand = inputs.get(FIRST_OPERAND_INDEX);

        List<Memory> memories = new ArrayList<>();
        for (int index = 1;
             index < inputs.size();
             index = index + INDEX_INCREMENT) {
            String operator = inputs.get(index);
            String operand = inputs.get(index + OPERAND_OFFSET);
            memories.add(new Memory(Operator.convertToOperator(operator), new Operand(operand)));
        }

        return new Calculator(new Operand(firstOperand), memories.toArray(Memory[]::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(inputs, input.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }
}
