package step1.calc.operation.subtraction;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Subtraction implements Operation {

    @Override
    public Operand operate(Operand a, Operand b) {
        return new Operand(a.operand() - b.operand());
    }
}
