package calculator;

import calculator.domain.StringCalculator;

import static calculator.view.InputView.*;
import static calculator.view.ResultVIew.*;

public class CalculatorApplication {
    public static void main(String[] args) {
        String[] textArray = inputText();

        StringCalculator stringCalculator = new StringCalculator(textArray);
        int result = stringCalculator.startOperation();
        printResult(result);


    }
}
