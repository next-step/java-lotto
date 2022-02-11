package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Parser;
import calculator.model.Token;
import calculator.model.Adder;

public class Calculator {

    private static Calculator calculator = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return calculator;
    }

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String userInput = inputView.getUserInput();
        Parser parser = new Parser(userInput);
        Token token = parser.parseInput();
        Adder adder = new Adder(token);
        outputView.printResult(adder.calculate());
    }
}
