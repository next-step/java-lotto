package stringcalculator.view;

import stringcalculator.model.Result;

public class ResultView {

    public static final String RESULT_PREFIX = "결과: ";

    public static void print(Result result) {
        System.out.println(RESULT_PREFIX + result.value());
    }
}
