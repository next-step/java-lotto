package calculator;

import calculator.domain.Calculator;
import calculator.domain.NumberSentence;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        NumberSentence numberSentence
                = new NumberSentence(new InputView().inputNumberSentence());

        Calculator calculator = new Calculator();
        int result = calculator.calculate(numberSentence.getNumberList(), numberSentence.getOperationList());

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}
