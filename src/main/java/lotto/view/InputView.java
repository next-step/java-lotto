package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "구입금액을 입력해 주세요.";

    public static int inputData() {
        System.out.println(QUESTION_START);
        return SCANNER.nextInt();
    }
}
