package lotto.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static int getLottoMoney() {
        System.out.println(INPUT_MESSAGE_LOTTO_MONEY);
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        return scanner.nextLine();
    }
}
