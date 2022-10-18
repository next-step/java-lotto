package domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String SPACE = " ";
    private static final String NUMBER_FORMAT = "\\d+";
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Calculator(String value) {
        if (isValid(value)) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
        separateValue(value.split(SPACE));
    }

    private boolean isValid(String value) {
        return value == null || value.isEmpty();
    }

    public void separateValue(String[] value) {
        for (int index = 0; index < value.length; index++) {
            addValue(value, index);
        }
    }

    private void addValue(String[] value, int index) {
        if (isOddNumber(index)) {
            validateNumber(value[index]);
            numbers.add(Integer.valueOf(value[index]));
            return;
        }
       operators.add(Operator.of(value[index]));
    }

    private boolean isOddNumber(int index) {
        return index % 2 == 0;
    }

    private void validateNumber(String value) {
        if (!value.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperators() {
        return operators;
    }
}
