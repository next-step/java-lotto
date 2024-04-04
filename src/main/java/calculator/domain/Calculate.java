package calculator.domain;

import calculator.controller.Calculator;

import java.util.List;

public class Calculate {

    public static int calculate(String expression) {
        List<List<String>> operandAndOperator = Calculator.operandsAndOperators(expression);
        List<Integer> operands = Calculator.operands(operandAndOperator);
        List<Operator> operators = Calculator.operators(operandAndOperator);

        return calculate(operands, operators);
    }

    public static int calculate(List<Integer> operands, List<Operator> operators) {
        int result = Operator.calculate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < (operators.size()); i++) {
            result = Operator.calculate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }
}
