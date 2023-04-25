package step1.domain;

import step1.domain.model.InputStack;
import step1.domain.model.Operation;

public class ArithmeticCalculatorService {
    private static final int LAST_INDEX = 1;

    private InputStack inputStack;

    public ArithmeticCalculatorService(String input) {
        this.inputStack = InputStack.from(input);
    }

    public static ArithmeticCalculatorService from(String input) {
       return new ArithmeticCalculatorService(input);
    }

    public void calculator() {
        while (inputStack.getSize() != LAST_INDEX) {
            String leftNumber = inputStack.pop();
            String operationString = inputStack.pop();
            String rightNumber = inputStack.pop();

            String calculatorResult = Operation.from(operationString)
                    .calculator(leftNumber, rightNumber);

            inputStack.push(calculatorResult);
        }
    }

    public int getCalculatorResult() {
        return Integer.parseInt(inputStack.pop());
    }
}
