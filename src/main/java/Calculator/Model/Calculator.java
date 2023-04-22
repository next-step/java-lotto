package Calculator.Model;

import Calculator.Enums.Operator;

public class Calculator {
    private static final String INITIAL_NUMBER = "0";
    private static final String INITIAL_OPERATOR = "+";

    private final Number result;
    private final Symbol symbol;
    private final Number newNumber;

    public Calculator() {
        result = new Number(INITIAL_NUMBER);
        symbol = new Symbol(INITIAL_OPERATOR);
        newNumber = new Number(INITIAL_NUMBER);
    }


    public void type(String element) {
        if (!newSymbol(element) && !newNumber(element)) {
            throw new IllegalArgumentException("숫자나 연산자가 아닙니다.");
        }

        execute(result.currentNumber(), symbol.currentSymbol(), newNumber.currentNumber());
    }

    private boolean newNumber(String element) {
        try {
            newNumber.changeNumber(Integer.parseInt(element));
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private boolean newSymbol(String element) {
        try {
            symbol.changeSymbol(element);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public void execute(int numberBeforeOperator, String operator, int numberAfterOperator) {
        int currentNumber = Operator.execute(numberBeforeOperator, operator, numberAfterOperator);
        result.changeNumber(currentNumber);
    }

    public String currentOperator() {
        return symbol.currentSymbol();
    }

    public int currentResult() {
        return result.currentNumber();
    }
}

