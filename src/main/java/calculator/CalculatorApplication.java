package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorController calculator = new CalculatorController(new CalculatorService());
        Output.printResult(calculator.calculator(Input.getInput()));
    }

}
