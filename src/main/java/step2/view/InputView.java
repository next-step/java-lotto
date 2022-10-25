package step2.view;

import step2.domain.PurchasePrice;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() {}

    public static PurchasePrice purchasePriceInput() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return new PurchasePrice(SCANNER.nextLine());
    }

}