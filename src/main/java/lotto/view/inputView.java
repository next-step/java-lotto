package lotto.view;

import lotto.utils.PreConditionUtil;

import java.util.Scanner;

public class inputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static String purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        String purchaseAmount = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(purchaseAmount);
        return purchaseAmount;
    }

    public static String winningNumbers() {
        System.out.println(WINNING_NUMBERS);
        String winningNumbers = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(winningNumbers);
        return winningNumbers;
    }
}
