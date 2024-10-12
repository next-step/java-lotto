package stringcalculator.ui.output;

import stringcalculator.model.Number;

public class ConsoleOutputView implements OutputView{

    public static final String RESULT_MESSAGE = "결과";

    @Override
    public void printResult(Number number) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(number);
    }
}
