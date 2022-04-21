package lotto.ui;

import lotto.exception.InvalidPriceException;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPrice() {
        System.out.println(PURCHASE_PRICE);
        int price = SCANNER.nextInt();
        validatePrice(price);
        return price;
    }

    public static void validatePrice(int price) {
        if (price < 0) {
            throw new InvalidPriceException(price);
        }
    }
}
