import domain.Calculator;
import util.OperationUtil;
import view.InputView;
import view.ResultView;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern OPERATORS_PATTERN = Pattern.compile("[-+*/]");
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String input = inputView.scanInput();
        String[] splitString = OperationUtil.splitString(input);

        List<String> numbers = new LinkedList<>();
        List<String> signs = new LinkedList<>();

        for (String s : splitString) {
            if (OPERATORS_PATTERN.matcher(input).find()) {
                signs.add(s);
                continue;
            }
            numbers.add(s);
        }
        int result = calculator.operate(numbers, signs);
        resultView.printResult(result);
    }
}
