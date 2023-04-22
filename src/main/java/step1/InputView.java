package step1;

import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";
    private static final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
    }

    public String request() {
        System.out.println("계산식을 입력해주세요.");
        return SCANNER.nextLine().replaceAll(BLANK, "");
    }
}
