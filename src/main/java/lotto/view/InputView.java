package lotto.view;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_OF_MONEY_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static PurchaseAmountOfMoney enteredPurchaseAmountOfMoney() {
        System.out.println(PURCHASE_AMOUNT_OF_MONEY_INPUT_GUIDE_MESSAGE);
        return PurchaseAmountOfMoney.valueOf(SCANNER.nextLine());
    }

    public static WinningNumbers enteredWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
        return WinningNumbers.valueOf(SCANNER.nextLine());
    }
}
