package stringcalulator;

import stringcalulator.view.InputView;
import stringcalulator.view.ResultView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String formula = inputView.inputValue("계산식을 입력하세요");

        Calculate calculate = new Calculate(formula);
        calculate.operate();
        Double result = calculate.getResult();

        ResultView resultView = new ResultView();
        resultView.result(result);


    }
}
