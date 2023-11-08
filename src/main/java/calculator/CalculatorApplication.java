package calculator;

import static calculator.InputView.*;

public class CalculatorApplication {
    public static void main(String[] args) {
        String text = inputText();

        StringCalculator stringCalculator = new StringCalculator(text);
        int result = stringCalculator.startOperation(stringCalculator.splitText());
        System.out.println(result);



    }
}
