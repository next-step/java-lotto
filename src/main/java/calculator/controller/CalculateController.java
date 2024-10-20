package calculator.controller;

import calculator.calculate.CalculatorService;
import calculator.input.Numbers;
import calculator.input.Separator;
import calculator.input.Symbols;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculateController {

    private final InputView inputView;
    private final ResultView resultView;

    public CalculateController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startCalculate() {
        String inputStr = inputView.calInput();

        Separator separator = new Separator(inputStr);
        Symbols symbols = separator.separateSymbols();
        Numbers numbers = separator.separateNumbers();

        CalculatorService calculator = new CalculatorService();
        resultView.printResult(calculator.calculate(numbers, symbols));

    }
}
