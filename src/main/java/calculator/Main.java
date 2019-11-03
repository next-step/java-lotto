package calculator;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<Integer> numbers = Parser.convertToInteger(inputView.getInputValue());
        int result = Calculator.calculate(numbers);

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
