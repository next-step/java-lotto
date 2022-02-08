package calculator;

public class Calculator {
    
    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String userInput = inputView.inputExpression();
        Adder adder = new Adder(Parser.parseInput(userInput));
        outputView.printResult(adder.calculate());
    }
}
