package controller;

import domain.Calculator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ui.InputView;

public class CalcMain {

    public static void main(String[] args) {

        List<String> input = Arrays.asList(InputView.inputString().split(" "));

        int result = Integer.parseInt(input.get(0));
        for (int i = 0; i < input.size() - 2; i += 2) {
            result = stringCalulator(result, String.valueOf(input.get(i + 1)), Integer.parseInt(input.get(i + 2)));
        }
        System.out.println("연산 결과는 " + result + " 입니다.");
    }



    private static int stringCalulator(int result, String operator, int num) {
        Calculator calculator = new Calculator();
        checkOperator(operator);
        if ("+".equals(operator)) {
            return calculator.add(result, num);
        }
        if ("-".equals(operator)) {
            return calculator.substract(result, num);
        }
        if ("*".equals(operator)) {
            return calculator.multiply(result, num);
        }
        if ("/".equals(operator)) {
            return calculator.divide(result, num);
        }
        return result;
    }

    private static void checkOperator(String operator) {
        if(!("+".equals(operator) || "-".equals(operator) || "*".equals(operator) ||"/".equals(operator)))
            throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 만 가능합니다.");
    }
}
