package lotto.view;

import java.util.Scanner;

import lotto.utils.StringUtil;

public class InputView {
    private final static String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String MESSAGE_BONUS_BALL = "\n보너스 볼을 입력해주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static String[] inputWinNumber() {
        System.out.println(MESSAGE_WIN_NUMBER);
        return StringUtil.split(scanner.nextLine());
    }

    public static String inputBonusBall() {
        System.out.println(MESSAGE_BONUS_BALL);
        return scanner.nextLine();
    }

}
