package stringcalculator;

import static stringcalculator.domain.Calculator.calculator;

import java.util.List;
import stringcalculator.domain.Number;
import stringcalculator.domain.Separator;
import stringcalculator.domain.StringNumber;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculator {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final StringNumber userInput = new StringNumber(inputView.inputCalculateString());

        final Separator separator = new Separator(userInput.getStringNumber());

        final List<String> userNumbers = separator.split();
        final Number numbers = new Number(userNumbers);
        final ResultView resultView = new ResultView();
        resultView.printSum(calculator.calculate(numbers.getNumberInput()));
    }
}
