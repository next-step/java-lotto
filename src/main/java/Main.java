import domain.Calculator;
import util.OperationUtil;
import view.InputView;
import view.ResultView;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int result = calculateInput(inputView.scanInput());
        resultView.printResult(result);
    }

    public static int calculateInput(String line) {
        String[] divided = OperationUtil.splitString(line);

        List<String> numbers = new LinkedList<>();
        List<String> signs = new LinkedList<>();

        for (String s : divided) {
            if (Pattern.compile("[-+*/]").matcher(s).find()) {
                signs.add(s);
                continue;
            }
            numbers.add(s);
        }
        return Calculator.operate(numbers, signs);
    }
}
