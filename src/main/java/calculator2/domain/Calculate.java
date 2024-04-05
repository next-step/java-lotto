package calculator2.domain;

import calculator2.controller.Calculator;

import java.util.List;

public class Calculate {
    public static int calculate (String expression) {
        List<Integer> operands;
        List<Operator> operators;
        try {
            List<List<String>> operandsAndOperators = Calculator.operandsAndOperators(expression);
            operands = Calculator.operands(operandsAndOperators);
            operators = Calculator.operators(operandsAndOperators);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("문자열 입력이 잘못되었습니다. 형식을 맞춰 입력해주세요.");
        }

        return calculate(operands, operators);
    }

    public static int calculate (List<Integer> operands, List<Operator> operators) {
        if (operands.size() == 1) {
            return operands.get(0);
        }

        int result = operators.get(0).calculate(operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = operators.get(i).calculate(result, operands.get(i + 1));
        }
        return result;
    }
}
