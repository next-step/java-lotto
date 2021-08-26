package stringcalculator;

import java.util.Scanner;

public class InputView {

    private InputView() {
        throw new AssertionError("InputView 클래스는 객체를 생성할 수 없습니다.");
    }

    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산식을 입력하세요.");
        return sc.nextLine();
    }
}
