package step2.view;

import step2.domain.PurchasePrice;
import step2.util.Utils;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요. (한장에 1000원)";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {}

    public static PurchasePrice purchasePriceInput() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return new PurchasePrice(SCANNER.nextLine());
    }

    public static void winningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        Utils.winningNumbers(SCANNER.nextLine());
    }

}