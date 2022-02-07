package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Parser;
import calculator.model.Token;
import calculator.model.Adder;
import java.util.List;

public class Calculator {
    private static Calculator calculator= new Calculator();
    private Calculator(){
    }
    public static Calculator getInstance(){
        return calculator;
    }
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
