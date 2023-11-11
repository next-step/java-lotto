package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString() {
        System.out.println("숫자와 사칙연산 사이에 빈 공백 문자열이 들어가도록 입력해주세요. < 예) 2 + 3 * 4 >");
        return SCANNER.nextLine();
    }
}
