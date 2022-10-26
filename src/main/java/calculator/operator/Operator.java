package calculator.operator;

import calculator.exception.ParsingOperatorFailureException;

public abstract class Operator {

    public abstract int exec(int first, int second);

    public static Operator valueOf(String operatorStr) {
        if ("+".equals(operatorStr)) {
            return new AddOperator();
        } else if ("-".equals(operatorStr)) {
            return new SubOperator();
        } else if ("*".equals(operatorStr)) {
            return new MulOperator();
        } else if ("/".equals(operatorStr)) {
            return new DivOperator();
        }

        throw new ParsingOperatorFailureException();
    }
}
