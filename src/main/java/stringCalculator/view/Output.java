package stringCalculator.view;

import java.text.MessageFormat;

public class Output {

    private Output() {
    }

    public static void printNumericFormula(long sum) {
        System.out.println(MessageFormat.format("계산된 결과값은 {0} 입니다", sum));
    }
}
