package calculator;

public class CalculatorMain {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        int result = calculatorController.start("2 + 3 * 4 / 2");
        System.out.println(result);
    }
}
