package calculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner SC = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static String console() {
        System.out.println("사칙연산 문자열을 입력하시오.");
        return SC.nextLine();
    }
}