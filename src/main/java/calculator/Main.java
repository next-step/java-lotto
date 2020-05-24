package calculator;

public class Main {

    public static void main(String[] args) {
        String userInput = InputView.getUserInput();

        Numbers numbers = new Numbers(StringParser.parseString(userInput));
        Integer calculationResult = StringAddCalculator.getNumbersSum(numbers);

        ResultView.printResult(calculationResult);
    }
}
