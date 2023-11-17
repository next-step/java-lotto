package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int calculate(String text) {
        String[] splitArr = text.split(" ");

        List<String> operateList = createOperateList(splitArr);

        List<Integer> numberList = createNumberList(splitArr);

        int result = numberList.get(0);

        for (int i = 0; i < operateList.size(); i++) {

            String operator = operateList.get(i);
            int number = numberList.get(i + 1);

            if ("+".equals(operator)) {
                result = plus(result, number);
            }
            if ("-".equals(operator)) {
                result = minus(result, number);
            }
            if ("*".equals(operator)) {
                result = multiply(result, number);
            }
            if ("/".equals(operator)) {
                result = divide(result, number);
            }
        }
        return result;
    }

    private List<String> createOperateList(String[] splitArr) {
        return Arrays.stream(splitArr)
                .filter(el -> !isNumber(el))
                .collect(Collectors.toList());
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