package stringcalculator;

import java.util.List;
import stringcalculator.domain.Calculator;
import stringcalculator.domain.Number;
import stringcalculator.domain.Separator;
import stringcalculator.domain.UserInput;
import stringcalculator.view.ResultView;

public class StringCalculator {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Separator separator = new Separator(userInput.getUserInput());

        List<String> userNumbers = separator.split();
        Number numbers = new Number(userNumbers);
        Calculator calculator = new Calculator();
        ResultView resultView = new ResultView();
        resultView.printSum(calculator.calculate(numbers.getNumberInput()));
    }
}
