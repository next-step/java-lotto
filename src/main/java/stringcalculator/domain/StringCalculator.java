package stringcalculator.domain;

import stringcalculator.domain.Operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int calculate(String text) {
        if (isNullOrBlank(text)) {
            throw new IllegalArgumentException("null 값이나 공백은 입력할 수 없습니다");
        }

        String[] splitArr = text.split(" ");

        List<Operator> operateList = createOperateList(splitArr);

        List<Integer> numberList = createNumberList(splitArr);

        int result = numberList.get(0);
        result = calculation(operateList, numberList, result);
        return result;
    }

    private static int calculation(List<Operator> operateList, List<Integer> numberList, int result) {
        for (int i = 0; i < operateList.size(); i++) {
            Operator operator = operateList.get(i);
            int number = numberList.get(i + 1);

            result = getResult(result, operator, number);
        }
        return result;
    }

    private static int getResult(int result, Operator operator, int number) {
        if (operator == Operator.PLUS) {
            result = plus(result, number);
        }
        if (operator == Operator.MINUS) {
            result = minus(result, number);
        }
        if (operator == Operator.MULTIPLY) {
            result = multiply(result, number);
        }
        if (operator == Operator.DIVIDE) {
            result = divide(result, number);
        }
        return result;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private List<Operator> createOperateList(String[] splitArr) {
        return Arrays.stream(splitArr)
                .filter(el -> !isNumber(el))
                .map(this::getOperatorFromString)
                .collect(Collectors.toList());
    }

    private Operator getOperatorFromString(String operator) {
        return Operator.fromName(operator);
    }

    private List<Integer> createNumberList(String[] splitArr) {
        return Arrays.stream(splitArr)
                .filter(el -> isNumber(el))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int plus(int number1, int number2) {
        return number1 + number2;
    }

    private static int minus(int number1, int number2) {
        return number1 - number2;
    }

    private static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    private static int divide(double number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("나눗셈은 0으로 나눌 수 없습니다.");
        }
        return (int) Math.ceil(number1 / number2);
    }
}