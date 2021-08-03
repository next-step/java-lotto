package StringCalculator.domain;

import java.util.List;

public class SubtractingStrategy implements OperateStrategy {

    @Override
    public int operate(List<Integer> operands) {
        return operands.stream().reduce(0, (a, b) -> a - b);
    }
}
