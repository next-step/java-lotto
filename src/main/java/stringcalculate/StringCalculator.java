package stringcalculate;

import java.util.*;

public class StringCalculator {
    private final List<Integer> numbers = new ArrayList<>();
    private final List<String> operators;
    public static final Map<String, Operator> operatorMap = new HashMap<>();
    private int result = 0;

    static {
        for (Operator value : Operator.values()) {
            operatorMap.put(value.getOperator(), value);
        }
    }

    public StringCalculator(InputValue inputValue) {
        this.numbers.addAll(inputValue.getNumbers());
        this.operators = inputValue.getOperators();
    }

    public int calculate() {
        for (int i = 0; i < operators.size(); i++) {
            result = operatorMap.get(operators.get(i)).calculate(numbers.get(i), numbers.get(i + 1));
            replaceResult(i);
        }
        return result;
    }

    private void replaceResult(int i) {
        numbers.set(i + 1, result);
    }

}
