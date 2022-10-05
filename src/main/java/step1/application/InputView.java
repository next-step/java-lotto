package step1.application;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String input() {
        System.out.println("연산을 입력해주세요.");
        return SCANNER.nextLine();
    }

}
