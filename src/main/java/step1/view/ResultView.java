package step1.view;

import step1.domain.Number;

public class ResultView {
    private static final String OUTPUT_MESSAGE = "계산 결과";
    private static final String ERROR_MESSAGE = "잘못된 수식을 입력하셨습니다. 다시 입력해주세요.";

    public void printResult(Number result) {
        System.out.printf("%s: %d%n", OUTPUT_MESSAGE, result.getValue());
    }

    public void printError() {
        System.out.println(ERROR_MESSAGE);
    }
}
