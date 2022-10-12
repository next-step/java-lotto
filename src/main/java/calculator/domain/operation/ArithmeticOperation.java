package calculator.domain.operation;

import calculator.domain.CalcNumber;

public interface ArithmeticOperation {
    CalcNumber calculator(CalcNumber a, CalcNumber b);
}
