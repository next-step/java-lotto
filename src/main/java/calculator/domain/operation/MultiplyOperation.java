package calculator.domain.operation;

import calculator.domain.CalcNumber;

public class MultiplyOperation implements ArithmeticOperation {
    @Override
    public CalcNumber calculate(CalcNumber a, CalcNumber b) {
        return new CalcNumber(a.getNumber() * b.getNumber());
    }
}
