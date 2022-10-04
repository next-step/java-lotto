package step1;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InPutView.input();
        ResultView.print(Calculator.calculator(input));
    }
}
