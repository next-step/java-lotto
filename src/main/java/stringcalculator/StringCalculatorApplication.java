package stringcalculator;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String input = "2 2 3 * 4 / 2";
//        String input = "2 * 3 + 4 / 2";
        int result = calculator.calculate(input);
        System.out.println(result);
    }
}
