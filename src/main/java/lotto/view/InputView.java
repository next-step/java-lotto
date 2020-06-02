package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmount() {
        System.out.println(TextFixture.INPUT_AMOUNT_FOR_BUY_LOTTO);
        int buyAmount = scanner.nextInt();
        scanner.nextLine();
        return buyAmount;
    }

    public static String inputWinningNumber() {
        System.out.println(TextFixture.INPUT_WINNING_LOTTO_NUMBERS);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(TextFixture.INPUT_WINNING_LOTTO_BONUS_NUMBERS);
        int bonus = scanner.nextInt();
        scanner.nextLine();
        return bonus;
    }
}
