package lotto.ui;

import java.text.MessageFormat;

public class ResultView {

    public static void printExpressionResult(int result) {
        System.out.println(MessageFormat.format("결과: {0}", result));
    }

    public static void printExit() {
        System.out.println("프로그램이 종료되었습니다.");
    }
}
