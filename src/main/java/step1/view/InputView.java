package step1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static String askArithmeticCalculator() {
        System.out.println("계산할 문자열을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
