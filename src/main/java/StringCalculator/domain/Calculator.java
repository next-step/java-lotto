package StringCalculator.domain;

import java.util.List;

public class Calculator {

    public int operate(List<Integer> operands, OperateStrategy operateStrategy) {
        return operateStrategy.operate(operands);
    }
}
