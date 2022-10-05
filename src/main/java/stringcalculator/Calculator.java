package stringcalculator;

import java.util.List;

public class Calculator {

    private static final int FIRST_INDEX_OF_NUMBERS = 0;

    private Calculator() {}

    public static int calculate(CalculatorRequest request) {
        List<Integer> numbers = request.getNumbers();
        List<ArithmeticOperator> operators = request.getOperators();
        int accumulation = numbers.get(FIRST_INDEX_OF_NUMBERS);
        for (int i = 0; i < operators.size(); i++) {
            ArithmeticOperator operator = operators.get(i);
            accumulation = operator.calculate(accumulation, numbers.get(i + 1));
        }
        return accumulation;
    }

}
