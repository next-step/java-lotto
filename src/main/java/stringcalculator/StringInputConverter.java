package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringInputConverter {

    private static final String SPACE = " ";
    private static final int FIRST_INDEX_OF_NUMBER = 0;
    private static final int FIRST_INDEX_OF_OPERATOR = 1;
    private static final int STEP = 2;

    private StringInputConverter() {}

    public static CalculatorRequest convert(String input) {
        String[] numbersAndOperators = input.split(SPACE);
        List<Integer> numbers = getNumbers(numbersAndOperators);
        List<ArithmeticOperator> operators = getOperators(numbersAndOperators);
        return new CalculatorRequest(numbers, operators);
    }

    private static List<Integer> getNumbers(String[] numbersAndOperators) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = FIRST_INDEX_OF_NUMBER; i < numbersAndOperators.length; i += STEP) {
            numbers.add(Integer.parseInt(numbersAndOperators[i]));
        }
        return numbers;
    }

    private static List<ArithmeticOperator> getOperators(String[] numbersAndOperators) {
        List<ArithmeticOperator> operators = new ArrayList<>();
        for (int i = FIRST_INDEX_OF_OPERATOR; i < numbersAndOperators.length; i += STEP) {
            operators.add(ArithmeticOperator.from(numbersAndOperators[i]));
        }
        return operators;
    }

}
