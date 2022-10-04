package Step1;


public class CalculatorApplication {

    public static void main(String[] args) {
        String mathEquation = Printer.requestInput();

        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(mathEquation);

        Printer.printResult(result);
    }

}
