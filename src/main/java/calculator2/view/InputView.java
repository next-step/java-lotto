package calculator2.view;

import java.util.Scanner;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public static String userInputExpression() {
        System.out.println("문자열 계산기입니다. 원하시는 수식을 입력해주세요. (ex) 1 + 2 * 3 / 4");
        return scanner.nextLine();
    }
}
