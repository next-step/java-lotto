package calculator;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(InputView.getCalculationFormula());
        System.out.println("계산 결과: " + result);
    }
}
