import view.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {

        String inputValues = InputView.inputString();

        int result = Calculator.doCalculate(inputValues);

        ResultView.Result(result);

    }
}
