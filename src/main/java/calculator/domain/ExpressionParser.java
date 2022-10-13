package calculator.domain;

import calculator.domain.operator.*;
import calculator.view.CalculatorInput;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    private final String input;

    public ExpressionParser(String input) {
        this.input = input;
    }

    public CalculatorInput parseOperator() {
        String[] tokens = input.split(" ");
        CalculatorInput result = new CalculatorInput();
        result.setInit(Integer.parseInt(tokens[0]));
        try {
            result.setOperators(getOperators(tokens));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다: ", e);
        }
        return result;
    }

    private List<Operator> getOperators(String[] tokens) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < tokens.length; i++) {
            String operator = tokens[i++];
            int operand = Integer.parseInt(tokens[i]);
            operators.add(getOperator(operator, operand));
        }
        return operators;
    }

    private Operator getOperator(String operator, int operand) {
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
}
