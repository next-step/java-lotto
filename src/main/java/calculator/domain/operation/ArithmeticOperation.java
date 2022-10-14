package calculator.domain.operation;

import calculator.domain.CalcNumber;

public interface ArithmeticOperation {
    CalcNumber calculate(CalcNumber a, CalcNumber b);
}
