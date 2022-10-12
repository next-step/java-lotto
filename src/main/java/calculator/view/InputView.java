package calculator.view;

import calculator.domain.operator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static CalculatorInput scanInput() {
        System.out.println("계산할 식을 입력하세요.");
        String input = scanString();
        if (input.isBlank()) {
            throw new IllegalArgumentException("식이 입력되지 않았습니다.");
        }
        return parseOperator(input.split(" "));
    }

    private static CalculatorInput parseOperator(String[] tokens) {
        CalculatorInput result = new CalculatorInput();
        result.setInit(Integer.parseInt(tokens[0]));
        result.setOperators(getOperators(tokens));
        return result;
    }

    private static List<Operator> getOperators(String[] tokens) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < tokens.length; i++) {
            String operator = tokens[i++];
            int operand = Integer.parseInt(tokens[i]);
            operators.add(getOperator(operator, operand));
        }
        return operators;
    }

    private static Operator getOperator(String operator, int operand) {
        if (operator.equals("+")) {
            return new Plus(operand);
        }
        if (operator.equals("-")) {
            return new Minus(operand);
        }
        if (operator.equals("*")) {
            return new Multiple(operand);
        }
        if (operator.equals("/")) {
            return new Divide(operand);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닌 연산자가 입력되었습니다: " + operator);
    }

    private static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
