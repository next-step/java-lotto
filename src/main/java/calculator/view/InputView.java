package calculator.view;

import java.util.Scanner;

public final class InputView {
    private static final String ASK_INPUT_MESSAGE =
            "문자열 사칙연산 계산기입니다. 숫자와 연산자(+ , -, *, /) 사이에는 공백을 넣어 문자를 입력하세요.";

    private InputView() {
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASK_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
