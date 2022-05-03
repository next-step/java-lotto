package study.step1;

import study.step1.domain.StringCalculator;
import study.step1.view.InputView;
import study.step1.view.ResultView;

public class Application {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(InputView.inputStringFromUser());
        ResultView.print(stringCalculator.start());
    }
}
