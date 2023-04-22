package Calculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        try {
            calculatorController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            calculatorController.start();
        }

    }
}
