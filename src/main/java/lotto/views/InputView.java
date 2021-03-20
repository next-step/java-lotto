package lotto.views;

import java.util.Scanner;

public class InputView {
    public final static String AMOUNT = "구입금액을 입력해 주세요.";
    public final static String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public final static String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() { }

    public static String amount() {
        System.out.println(AMOUNT);
        return new Scanner(System.in).nextLine();
    }

    public static String winningNumbers() {
        System.out.println(WINNING_NUMBERS);
        return new Scanner(System.in).nextLine();
    }

    public static String bonusNumber() {
        System.out.println(BONUS_NUMBER);
        return new Scanner(System.in).nextLine();
    }

}
