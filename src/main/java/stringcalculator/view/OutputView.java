package stringcalculator.view;

import stringcalculator.domain.Number;

public class OutputView {
    public static void printAnswer(Number answer) {
        System.out.println(answer.getNumber());
    }
}
