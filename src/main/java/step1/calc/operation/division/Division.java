package step1.calc.operation.division;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;

public class Division implements Operation {

    @Override
    public Operand operate(Operand a, Operand b) {
        return new Operand(a.operand() / b.operand());
    }
}
