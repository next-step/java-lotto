package calculator;

import java.util.List;

public class Calculator {
    public Integer performSequentialArithmetics(List<Integer> operands, List<Operator> operators) {
        var accumulator = operands.get(0);
        for (int i = 0; i < operators.size(); ++i) {
            accumulator = operators.get(i).perform(accumulator, operands.get(i + 1));
        }
        return accumulator;
    }
}
