package step1;

import java.util.List;

public class Calculator {
    private final List<Operation> operations;

    private final List<Integer> operands;

    private Integer accumulator;

    Calculator(List<Operation> operations, List<Integer> operands) {
        this.operations = operations;
        this.operands = operands;
    }

    public int getResult() {
        if (operands.size() == 0) {
            return accumulator;
        }
        if (operands.size() == 1) {
            this.runSingleOperand();
            return accumulator;
        }
        this.runMultiOperand();
        return accumulator;
    }

    private void runMultiOperand() {
        while (operations.size() > 0) {
            this.runOperation();
        }
    }

    private void runSingleOperand() {
        accumulator = operands.remove(0);
    }

    private void runOperation() {
        Integer operand1 = this.accumulator;
        if (operand1 == null) {
            operand1 = operands.remove(0);
        }
        Integer operand2 = operands.remove(0);

        Operation operation = operations.remove(0);
        this.accumulator = operation.work(operand1, operand2);
    }
}
