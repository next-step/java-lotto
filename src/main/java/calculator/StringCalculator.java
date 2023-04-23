package calculator;

import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.domain.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final String SEPARATOR = " ";
    public static final int BEGIN_INDEX = 0;
    public static final int INCREMENT_NEXT_INDEX = 1;

    private Number result;

    public StringCalculator(String input) {

        String[] arr = input.split(SEPARATOR);

        List<Number> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int i = BEGIN_INDEX; i < arr.length; i++) {
            makeNumber(arr, numbers, i);
            makeOperator(arr, operators, i);
        }

        initResult(numbers.get(BEGIN_INDEX));

        for (int i = BEGIN_INDEX; i < operators.size(); i++) {
            calculate(operators, numbers, i);
        }
    }

    public int result() {
        return result.intValue();
    }

    private void initResult(Number number) {
        result = number;
    }

    private void calculate(List<Operator> operators, List<Number> numbers, int i) {
        OperatorType operator = operators.get(i).value();
        int calculatedResult = operator.calculate(result, numbers.get(i + INCREMENT_NEXT_INDEX));
        result = new Number(calculatedResult);
    }

    private static void makeNumber(String[] arr, List<Number> numbers, int i) {
        if (isEven(i)) {
            numbers.add(new Number(arr[i]));
        }
    }

    private static void makeOperator(String[] arr, List<Operator> operators, int i) {
        if (isOdd(i)) {
            operators.add(new Operator(arr[i]));
        }
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

}
