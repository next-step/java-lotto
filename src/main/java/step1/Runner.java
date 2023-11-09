package step1;

import step1.domain.Calculator;
import step1.domain.Seperator;
import step1.view.InputView;
import step1.view.ResultView;

public class Runner {

    public static void main(String[] args) {
        Seperator seperator = new Seperator(InputView.inputText());
        int result = Calculator.calculation(seperator.numbers(), seperator.operators());
        ResultView.printResult(result);
    }

}
