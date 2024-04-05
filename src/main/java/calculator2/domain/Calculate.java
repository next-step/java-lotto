package calculator2.domain;

import calculator2.controller.Calculator;

import java.util.List;

public class Calculate {
    public int calculate (String expression) {
        List<List<String>> operandsAndOperators = Calculator.operandsAndOperators(expression);
        List<Integer> operands = Calculator.operands(operandsAndOperators);
        List<Operator> operators = Calculator.operators(operandsAndOperators);
        int result = 0;

        for (int i = 0; i < operands.size(); i++) {
            result += operators.get(i).calculate(operands.get(i), operands.get(i + 1));
        }
        
        return result;
    }
}
