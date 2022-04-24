package calculator.view;

import calculator.model.Formula;
import calculator.util.Splitter;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Formula getFormula() {
        String input = inputStatement();
        List<String> numberAndOperator = Splitter.split(input);

        return new Formula(numberAndOperator);
    }

    public static String inputStatement() {
        return SCANNER.nextLine();
    }
}
