package step1.domain;

import java.util.List;

public class Calculator {

    public static int calculate(List<Operand> operands,  List<Operator> operators) {
        int result = operands.get(0).getValue(); // 첫 번째 피연산자부터 시작
        for (int i = 0; i < operators.size(); i++) {
            String operatorSymbol = operators.get(i).getSymbol();
            int operandValue = operands.get(i + 1).getValue();  // 다음 피연산자 값

            switch (operatorSymbol) {
                case "+":
                    result = add(String.valueOf(result), String.valueOf(operandValue));
                    break;
                case "-":
                    result = subtract(String.valueOf(result), String.valueOf(operandValue));
                    break;
                case "*":
                    result = multiply(String.valueOf(result), String.valueOf(operandValue));
                    break;
                case "/":
                    result = divide(String.valueOf(result), String.valueOf(operandValue));
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자: " + operatorSymbol);
            }
        }
        return result;
    }

    public static int add(String num1, String num2) { return Integer.parseInt(num1) + Integer.parseInt(num2); }

    public static int subtract(String num1, String num2) {
        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }

    public static int multiply(String num1, String num2) {
        return Integer.parseInt(num1) * Integer.parseInt(num2);
    }

    public static int divide(String num1, String num2) {
        return Integer.parseInt(num1) / Integer.parseInt(num2);
    }
}
