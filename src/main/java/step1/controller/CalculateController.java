package step1.controller;

import step1.service.CalculatorService;
import step1.utils.Views;

public class CalculateController {

    public static void start() {
        Views.output(CalculatorService.calculate(Views.input()));
    }
}
