package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private static final String DELIMITER = " ";
    private static final String NUMBER_PATTERN = "\\d+";
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Expression(String expression) {
        validate(expression);
        separateValue(expression.split(DELIMITER));
    }

    private void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
        }
    }

    private void separateValue(String[] value) {
        for (int i = 0; i < value.length; i++) {
            addValue(value, i);
        }
    }

    private void addValue(String[] value, int index) {
        if (isEven(index)) {
            validateNumber(value[index]);
            numbers.add(Integer.parseInt(value[index]));
            return;
        }
        operators.add(Operator.of(value[index]));
    }

    private boolean isEven(int index) {
        return index % 2 == 0;
    }

    private void validateNumber(String value) {
        if(!value.matches(NUMBER_PATTERN)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperator() {
        return operators;
    }
}
