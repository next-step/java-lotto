import calculator.Calculator;
import views.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {

        String formula = "2 + 3 * 4 / 2";

        ResultView.println(new Calculator(formula).calculateFormula());
    }
}
