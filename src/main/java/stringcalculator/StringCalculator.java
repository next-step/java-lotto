package stringcalculator;

import java.util.List;
import stringcalculator.domain.Numbers;
import stringcalculator.domain.Separator;
import stringcalculator.view.ResultView;
import stringcalculator.view.UserInput;

public class StringCalculator {

    public static void main(String[] args) {
        String userInput = new UserInput().userInputString();

        final Separator separator = new Separator(userInput);
        final List<String> userNumbers = separator.split();

        final Numbers numbers = new Numbers(userNumbers);

        final ResultView resultView = new ResultView();
        resultView.printSum(numbers.sum());
    }
}
