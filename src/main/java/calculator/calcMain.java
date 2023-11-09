package calculator;

import calculator.domain.Constituent;
import calculator.support.SplitSupport;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class calcMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Constituent constituent = new Constituent(SplitSupport.split(inputView.inputCalculateString()));

        ResultView resultView = new ResultView();
        resultView.printResult(constituent.StartCounter());
    }
}
