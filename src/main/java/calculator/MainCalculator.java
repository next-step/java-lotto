package calculator;

import calculator.domain.StringCalculator;
import calculator.io.handler.InputHandler;
import calculator.io.handler.OutputHandler;

public class MainCalculator {
    public static void main(String[] args) {
        String inputString = InputHandler.INSTANCE.readLine();

        StringCalculator stringCalculator = new StringCalculator();
        int calcResult = stringCalculator.calculate(inputString);

        OutputHandler.INSTANCE.printOut(calcResult);
    }
}
