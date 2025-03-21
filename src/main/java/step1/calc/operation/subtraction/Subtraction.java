package step1.calc.operation.subtraction;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Subtraction implements Operation {

    private final Operand result;

    public Subtraction(Operand a, Operand b) {
        result = new Operand(a.operand() - b.operand());
    }

    @Override
    public Operand operate() {
        return result;
    }
}
