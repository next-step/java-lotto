package step1;

import java.util.List;

import step1.domain.Number;
import step1.domain.Operator;

public class ParserResult {
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "연산자의 갯수는 숫자의 갯수보다 적어야 합니다.";

    private final List<Number> numbers;
    private final List<Operator> operators;

    public ParserResult(List<Number> numbers, List<Operator> operators) {
        validate(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    private void validate(List<Number> numbers, List<Operator> operators) {
        if (operators.size() != numbers.size() - 1) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
