package calculator.operator;

import calculator.exception.ParsingOperatorFailureException;

public abstract class Operator {

    public abstract int exec(int first, int second);

    public static Operator valueOf(String operatorStr) {
        switch (operatorStr) {
            case "+":
                return new AddOperator();
            case "-":
                return new SubOperator();
            case "*":
                return new MulOperator();
            case "/":
                return new DivOperator();
        }

        throw new ParsingOperatorFailureException();
    }
}
