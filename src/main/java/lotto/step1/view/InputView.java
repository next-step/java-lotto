package lotto.step1.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println("문자열을 입력해주세요");
        return scanner.next();
    }

}
