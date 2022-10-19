package stringcalculator;


import stringcalculator.arithmetic.ArithmeticOperation;
import stringcalculator.arithmetic.ArithmeticOperationFactory;

public class StringCalculator {

    private final ArithmeticOperationFactory arithmeticOperationFactory;
    private final String[] inputs;

    public StringCalculator(Input input) {
        this.arithmeticOperationFactory = new ArithmeticOperationFactory();
        this.inputs = input.getValue();
    }

    public int calculate() {
        Number result = new Number(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = calculate(result, new Number(inputs[i + 1]), getOperation(inputs[i]));
        }
        return result.toInt();
    }

    private Number calculate(Number firstNumber, Number secondNumber, ArithmeticOperation operation) {
        return firstNumber.calculate(secondNumber, operation);
    }

    private ArithmeticOperation getOperation(String operationCandidate) {
        return arithmeticOperationFactory.getOperation(operationCandidate);
    }
}
