package study.calculator.view;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("더할 숫자들을 입력해주세요.");
        return scanner.next();
    }
}
