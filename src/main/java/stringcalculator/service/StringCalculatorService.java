package stringcalculator.service;

import stringcalculator.model.Expression;
import stringcalculator.model.Number;
import stringcalculator.model.Operator;

public class StringCalculatorService {

    public Number calculateBasic(Number n1, Number n2, Operator op) {
        return op.calculate(n1, n2);
    }

    public Number calculate(Expression expression) {
        Number ret = calculateBasic(expression.getNextNumber(),
                                    expression.getNextNumber(),
                                    expression.getNextOperator());
        for (int i = 1 ; i < expression.getOperatorSize() ; i++) {
            ret = calculateBasic(ret, expression.getNextNumber(), expression.getNextOperator());
        }

        return ret;
    }
}
