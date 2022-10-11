import static view.InputView.inputEquation;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String[] input = inputEquation();
        StringCalculator calculator = new StringCalculator();

        System.out.printf("실행 결과: %d", calculator.calculate(input));
    }
}
