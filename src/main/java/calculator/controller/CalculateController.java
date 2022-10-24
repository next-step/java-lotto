package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculateController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        startCalculate(inputView.scanString());
    }

    private void startCalculate(String input) {

        Calculator calculator = new Calculator();
        Parser parser = new Parser();

        outputView.printResult(calculator.calculate((parser.parseString(input))));
    }
}
