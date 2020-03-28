package study.calculator.view;

import java.util.Scanner;

public class InputView {
    private static final String INFORMATION = "더할 숫자들을 입력해주세요.";

    private InputView() {
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INFORMATION);
        return scanner.next();
    }
}
