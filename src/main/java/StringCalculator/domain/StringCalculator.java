package StringCalculator.domain;

import java.util.List;

public class StringCalculator {

    public int operate(OperationInputs operationInputs) {
        OperateStrategy operateStrategy = operationInputs.getStrategy();
        List<Integer> operands = operationInputs.getOperandsList();

        return operateStrategy.operate(operands);
    }
}
