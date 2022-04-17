package calculator.view;

import calculator.model.Number;

public class OutputView {

    public static final String INVALID_CALCULATION_DETECT_MESSAGE = "잘못된 연산이 감지되었습니다.";

    private static final String RESULT_MESSAGE_FORMAT = "계산 결과를 %s 입니다.";

    public OutputView() {
    }

    public void printResult(Number number) {
        System.out.printf(RESULT_MESSAGE_FORMAT, number.getValue());
    }

    public void printErrorMessage(String message) {
        System.out.println(INVALID_CALCULATION_DETECT_MESSAGE);
        System.out.println(message);
    }
}
