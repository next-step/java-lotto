package stringcalculator;

import static stringcalculator.domain.Calculator.calculator;

import java.util.List;
import stringcalculator.domain.Line;
import stringcalculator.domain.Numbers;
import stringcalculator.domain.Separator;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculator {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final Line line = inputView.inputCalculateString();

        final Separator separator = new Separator(line.getLine());

        //TODO numbers 네이밍... 생각해보기
        final List<Integer> userNumbers = separator.splitAsInteger();
        final Numbers numbers = new Numbers(userNumbers);
        final ResultView resultView = new ResultView();
        resultView.printSum(calculator.calculate(numbers.getNumberInput()));
    }
}
