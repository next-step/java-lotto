package calculator;

import calculator.view.InputView;

import java.util.List;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();

    public static void main(String[] args) {
        List<String> formula = receiveFormula();
    }

    private static List<String> receiveFormula() {
        try {
            return INPUT_VIEW.receiveFormula();
        } catch (IllegalArgumentException e) {
            return receiveFormula();
        }
    }
}
