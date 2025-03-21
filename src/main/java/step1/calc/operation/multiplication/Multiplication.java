package step1.calc.operation.multiplication;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Multiplication implements Operation {

    private final Operand result;

    public Multiplication(Operand a, Operand b) {
        result = new Operand(a.operand() * b.operand());
    }

    @Override
    public Operand operate() {
        return result;
    }
}
