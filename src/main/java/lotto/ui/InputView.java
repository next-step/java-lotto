package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MONEY_GUIDE = "구입 금액을 입력해 주세요.";

    public static long inputMoney() {
        System.out.println(INPUT_MONEY_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
}
