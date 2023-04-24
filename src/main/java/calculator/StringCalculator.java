package calculator;

import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.domain.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String SEPARATOR = " ";
    private static final int BEGIN_INDEX = 0;
    private static final int INCREMENT_NEXT_INDEX = 1;
    private static final int INCREMENT_COUNT = 2;

    public static Number calculate(String input) {
        String[] arr = makeArr(input);

        List<Number> numbers = makeNumbers(arr);
        List<Operator> operators = makeOperators(arr);

        return calculateInOrder(numbers, operators);
    }

    private static String[] makeArr(String input) {
        return input.split(SEPARATOR);
    }

    private static List<Number> makeNumbers(String[] arr) {
        List<Number> numbers = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < arr.length; i += INCREMENT_COUNT) {
            numbers.add(new Number(arr[i]));
        }
        return numbers;
    }

    private static List<Operator> makeOperators(String[] arr) {
        List<Operator> operators = new ArrayList<>();
        for (int i = BEGIN_INDEX + INCREMENT_NEXT_INDEX; i < arr.length; i += INCREMENT_COUNT) {
            operators.add(new Operator(arr[i]));
        }
        return operators;
    }

    private static Number calculateInOrder(List<Number> numbers, List<Operator> operators) {
        Number number = numbers.get(BEGIN_INDEX);

        for (int i = BEGIN_INDEX; i < operators.size(); i++) {
            OperatorType operator = operators.get(i).value();
            int calculatedResult = operator.calculate(number, numbers.get(i + INCREMENT_NEXT_INDEX));
            number = new Number(calculatedResult);
        }

        return number;
    }
}
