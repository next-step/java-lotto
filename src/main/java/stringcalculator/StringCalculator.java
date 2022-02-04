package stringcalculator;

import java.util.List;
import stringcalculator.domain.Calculator;
import stringcalculator.domain.Number;
import stringcalculator.domain.Separator;
import stringcalculator.domain.UserInput;
import stringcalculator.view.ResultView;

public class StringCalculator {

    public static void main(String[] args) {
        final UserInput userInput = new UserInput();
        final Separator separator = new Separator(userInput.getUserInput());

        final List<String> userNumbers = separator.split();
        final Number numbers = new Number(userNumbers);
        final Calculator calculator = new Calculator();
        final ResultView resultView = new ResultView();
        resultView.printSum(calculator.calculate(numbers.getNumberInput()));
    }
}
