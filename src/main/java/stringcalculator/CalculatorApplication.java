package stringcalculator;


import stringcalculator.service.CalculateService;
import stringcalculator.view.Printer;

public class CalculatorApplication {

    public static void main(String[] args) {
        String mathEquation = Printer.requestInput();

        CalculateService calculateService = new CalculateService();
        int result = calculateService.calculate(mathEquation);

        Printer.printResult(result);
    }

}
