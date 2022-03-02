package calculator;

import java.util.List;

public class Calculator {
    public void play(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String userInput = inputView.getUserInput();
        Parser parser = new Parser(userInput);
        List<Token> tokens = parser.parseInput();
        Adder adder = new Adder(tokens);
        outputView.printResult(adder.calculate());
    }
}
