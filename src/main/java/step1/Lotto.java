package step1;

import step1.domain.StringAddCalculator;
import step1.view.InputView;
import step1.view.ResultView;

public class Lotto {

    public static void main(String[] args) {
        String inputData = InputView.askQuestion();
        int sum = StringAddCalculator.splitAndSum(inputData);
        ResultView.result(sum);
    }
}
