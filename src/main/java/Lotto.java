import domain.StringAddCalculator;
import view.InputView;
import view.ResultView;

public class Lotto {

    public static void main(String[] args) {
        String inputData = InputView.askQuestion();
        int sum = StringAddCalculator.splitAndSum(inputData);
        ResultView.result(sum);
    }
}
