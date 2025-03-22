package step1.calc.operation;

import step1.calc.operand.Operand;

public interface Operation {

    Operand operate(Operand a, Operand b);
}
