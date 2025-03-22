package step1.calc.operation.multiplication;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Multiplication implements Operation {

    @Override
    public Operand operate(Operand a, Operand b) {
        return new Operand(a.operand() * b.operand());
    }
}
