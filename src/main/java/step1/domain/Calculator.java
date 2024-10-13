package step1.domain;

import step1.exception.WrongCalculationException;
import step1.model.Operands;
import step1.model.Operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private Operands operands = Operands.getInstance();
    private Operators operators = Operators.getInstance();

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
