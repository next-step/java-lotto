package lotto.views;

import java.util.Scanner;

public class InputView {
    public final static String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    public final static String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() { }

    public static String getInputAmount() {
        System.out.println(INPUT_AMOUNT);
        return new Scanner(System.in).nextLine();
    }

    public static String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
        return new Scanner(System.in).nextLine();
    }

}
