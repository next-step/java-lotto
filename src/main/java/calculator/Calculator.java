package calculator;

import java.util.List;

public class Calculator {

    private int result;

    public int calc(List<Integer> operands, List<Operator> operators) {
        initialize(operands);
        for (int index = 0; index <operators.size(); index++) {
            result = expressCalculating(operands.get(index+1), operators.get(index));
        }
        return result;
    }

    private int expressCalculating(Integer operand, Operator operator) {
        return operator.calculate(result, operand);
    }

    private void initialize(List<Integer> operands) {
        result = operands.get(0);
    }
}
