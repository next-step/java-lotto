package step1;

import step1.view.InputView;
import step1.view.ResultView;

public class StringAddCalculatorMain {

    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.splitAndSum(inputView.getCalculatorSign());

        resultView.showSumResult(result);
    }
}
