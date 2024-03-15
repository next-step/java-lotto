package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printString() {
        System.out.println("사칙연산 계산기 (공백을 두고 숫자 기호 순서로 입력하시오 ex) 2 + 3 * 4 / 2 )");
        System.out.println("결과 값이 2,147,483,647 을 넘으면 정확한 결과가 안나옵니다.");
    }

    public static String inputString() {
        printString();
        return scanner.nextLine();
    }
}
