package lotto.view;

import java.util.Scanner;

public class InputView {
    static final class TEXT {
        private static final String INPUT_AMOUNT_FOR_BUY_LOTTO = "구입금액을 입력해주세요";
        private static final String INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
        private static final String INPUT_WINNING_LOTTO_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmount() {
        System.out.println(TEXT.INPUT_AMOUNT_FOR_BUY_LOTTO);
        int buyAmount = scanner.nextInt();
        scanner.nextLine();
        return buyAmount;
    }

    public static String inputWinningNumber() {
        System.out.println(TEXT.INPUT_WINNING_LOTTO_NUMBERS);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(TEXT.INPUT_WINNING_LOTTO_BONUS_NUMBERS);
        int bonus = scanner.nextInt();
        scanner.nextLine();
        return bonus;
    }
}
