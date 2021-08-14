package lotto.step3.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println(INPUT_MONEY_MESSAGE);

        return sc.nextInt();
    }

}
