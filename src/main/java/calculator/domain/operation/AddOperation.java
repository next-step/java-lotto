package calculator.domain.operation;

import calculator.domain.CalcNumber;

public class AddOperation implements ArithmeticOperation {
    @Override
    public CalcNumber calculator(CalcNumber a, CalcNumber b) {
        return new CalcNumber(a.getNumber() + b.getNumber());
    }
}
