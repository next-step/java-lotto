import calculator.StringCalculator;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        String expression = InputView.getExpression();

        ResultView.show(new StringCalculator(expression).calculate());
    }
}
