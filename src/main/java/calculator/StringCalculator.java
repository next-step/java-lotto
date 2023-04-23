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
    public static final int INCREMENT_COUNT = 2;

    private Number result;

    public StringCalculator(String input) {

        String[] arr = input.split(SEPARATOR);

        List<Number> numbers = makeNumbers(arr);
        List<Operator> operators = makeOperators(arr);

        initResult(numbers.get(BEGIN_INDEX));

        calculate(numbers, operators);
    }

    public int result() {
        return result.intValue();
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

    private void initResult(Number number) {
        result = number;
    }

    private void calculate(List<Number> numbers, List<Operator> operators) {
        for (int i = BEGIN_INDEX; i < operators.size(); i++) {
            OperatorType operator = operators.get(i).value();
            int calculatedResult = operator.calculate(result, numbers.get(i + INCREMENT_NEXT_INDEX));
            result = new Number(calculatedResult);
        }
    }
}
