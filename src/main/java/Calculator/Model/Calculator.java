package Calculator.Model;

import Calculator.Enums.*;
import Calculator.View.InputView;

public class Calculator {
    private static final String INITIAL_NUMBER = "0";
    private static final String INITIAL_OPERATOR = "+";

    private final Number result;
    private final Number newNumber;

    private String operator;

    public Calculator() {
        result = new Number(INITIAL_NUMBER);
        operator = INITIAL_OPERATOR;
        newNumber = new Number(INITIAL_NUMBER);
    }


    public void type(String element) {
        if (InputView.isOperator(element)) {
            this.operator = element;
            return;
        }

        try {
            newNumber.changeNumber(Integer.parseInt(element));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        execute(result.currentNumber(), operator, newNumber.currentNumber());
    }

    public void execute(int numberBeforeOperator, String operator, int numberAfterOperator) {
        int currentNumber = Operator.execute(numberBeforeOperator, operator, numberAfterOperator);
        result.changeNumber(currentNumber);
    }

    public String currentOperator() {
        return operator;
    }

    public int currentResult() {
        return result.currentNumber();
    }
}

