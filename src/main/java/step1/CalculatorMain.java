package step1;

import step1.model.StringAddCalculator;
import step1.view.CalculatorInput;
import step1.view.CalculatorOutput;

public class CalculatorMain {

    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String inputString = CalculatorInput.inputGameCoin();

        int result = stringAddCalculator.splitAndSum(inputString);

        CalculatorOutput.printResult(result);
    }
}
