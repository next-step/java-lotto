package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE = "구입 금액을 입력 해주세요.";

    public static int input() {
        System.out.println(MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
