package step3.view;


import step3.utils.Constant;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askPurchaseAmount() {
        System.out.println(Constant.INPUT_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int askBonusNumber() {
        System.out.println(Constant.INPUT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String askWinningNumbers() {
        System.out.println(Constant.INPUT_LAST_WEEK_WINNING_NUMBERS);
        return scanner.nextLine();
    }

}