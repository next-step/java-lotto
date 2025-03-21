package step1.calc.operation.addition;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Addition implements Operation {

    private final Operand result;

    public Addition(Operand a, Operand b) {
        result = new Operand(a.operand() + b.operand());
    }

    @Override
    public Operand operate() {
        return result;
    }
}
