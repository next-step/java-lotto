package step1.calculator;

import step1.model.OperationWrapper;

public class StringCalculator {

    public StringCalculator() {
    }

    public int calculate(String input) {
        OperationWrapper operationWrapper = OperationWrapper.from(input);
        return operationWrapper.result();
    }
}
