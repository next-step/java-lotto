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

    private Number number;

    public StringCalculator(String input) {
        this.number = initNumber(input);
    }

    public Number calculateInOrderOf(String input) {
        String[] arr = makeArr(input);

        List<Number> numbers = makeNumbers(arr);
        List<Operator> operators = makeOperators(arr);

        calculateInOrder(numbers, operators);

        return number;
    }

    private Number initNumber(String input) {
        return new Number(makeArr(input)[BEGIN_INDEX]);
    }

    private String[] makeArr(String input) {
        return input.split(SEPARATOR);
    }

    private List<Number> makeNumbers(String[] arr) {
        List<Number> numbers = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < arr.length; i += INCREMENT_COUNT) {
            numbers.add(new Number(arr[i]));
        }
        return numbers;
    }

    private List<Operator> makeOperators(String[] arr) {
        List<Operator> operators = new ArrayList<>();
        for (int i = BEGIN_INDEX + INCREMENT_NEXT_INDEX; i < arr.length; i += INCREMENT_COUNT) {
            operators.add(new Operator(arr[i]));
        }
        return operators;
    }

    private void calculateInOrder(List<Number> numbers, List<Operator> operators) {
        for (int i = BEGIN_INDEX; i < operators.size(); i++) {
            OperatorType operator = operators.get(i).value();
            int calculatedResult = operator.calculate(number, numbers.get(i + INCREMENT_NEXT_INDEX));
            number = new Number(calculatedResult);
        }
    }
}
