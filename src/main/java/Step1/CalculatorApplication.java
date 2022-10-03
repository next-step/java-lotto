package Step1;

import Step1.intefaces.CalculatorService;

public class CalculatorApplication {

    public static void main(String[] args) {
        String mathEquation = Printer.requestInput();

        CalculatorService calculatorService = new CalculatorServiceImpl();
        int result = calculatorService.calculate(mathEquation);

        Printer.printResult(result);
    }

}
