package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String USER_INPUT_GUIDE = "구매 금액을 입력해주세요.";

    public static int inputMoney() {
        System.out.println(USER_INPUT_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
