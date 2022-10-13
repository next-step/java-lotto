package step1.controller;

import step1.service.CalculatorService;
import step1.view.InputView;
import step1.view.OutputView;

public class CalculateController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    public static void start() {
        OUTPUT_VIEW.output(CalculatorService.calculate(INPUT_VIEW.input()));
    }
}
