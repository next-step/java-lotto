package calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String userInput = View.inputExpression();
        List<Element> elements = Parser.parseExpression(userInput);
        int result = StringCalculator.calculate(elements);
        View.printResult(result);
    }
}
