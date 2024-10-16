package calculator.domain;

import calculator.exception.WrongCalculationException;
import calculator.model.Operands;
import calculator.model.Operators;

public class Calculator {
    private final Operands operands;
    private final Operators operators;

    public Calculator(Operands operands, Operators operators) {
        this.operands = operands;
        this.operators = operators;

    }

    public int calculate() throws WrongCalculationException {
        validatePreparationForCalculation();
        return calculateMain();
    }

    private void validatePreparationForCalculation() throws WrongCalculationException {
        if (operands.size() != operators.size() + 1) {
            throw new WrongCalculationException("잘못된 계산식입니다. 숫자 길이 : " + operands.size() + ", 기호 길이 : " + operators.size());
        }
    }

    private int calculateMain() {
        int result = operands.get(0);

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.getOperator(i);
            result = operator.calculate(result, operands.get(i + 1));
        }

        return result;
    }
}
