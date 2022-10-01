package step1;

import step1.input.StringCalculatorInput;
import step1.output.StringCalculatorOutput;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        StringCalculatorOutput.printStartMessage();

        String operation = StringCalculatorInput.operation();

        int calculateResult = StringCalculator.calculate(operation);

        StringCalculatorOutput.printResult(calculateResult);
    }
}
