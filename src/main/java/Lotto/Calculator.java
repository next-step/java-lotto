package lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String INVALID_INPUT = "유효하지 않은 입력값입니다.";
    private static final int EVEN_NUMBER = 2;

    public static void main(String[] args) {
        int result = Calculator.calculate(InputView.inputCalculation());
        ResultView.print(result);
    }

    public static int calculate(String valueText) {
        if (valueText == null || valueText.isBlank()) throw new IllegalArgumentException(INVALID_INPUT);

        String[] values = valueText.split(" ");
        List<Integer> numbers = splitNumbers(values);
        List<Operator> operators = splitOperators(values);

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i ++) {
            Operator operator = operators.get(i);
            result = operator.operate(result, numbers.get(i + 1));
        }

        return result;
    }

    private static List<Integer> splitNumbers(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (isOdd(i)) continue;
            numbers.add(toNumber(values[i]));
        }

        return numbers;
    }

    private static List<Operator> splitOperators(String[] values) {
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (isEven(i)) continue;
            operators.add(Operator.operatorOf(values[i]));
        }

        return operators;
    }

    private static int toNumber(String value) {
        if (value.isBlank()) throw new IllegalArgumentException(INVALID_INPUT);
        return Integer.parseInt(value);
    }

    private static boolean isEven(int value) {
        return value % EVEN_NUMBER == 0;
    }

    private static boolean isOdd(int value) {
        return value % EVEN_NUMBER != 0;
    }
}
