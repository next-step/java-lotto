package lottery.view;

import java.util.Scanner;

public class PurchasingPriceConsoleInput {

    private static final String PURCHASING_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public int askPurchasingPrice() {
        System.out.println(PURCHASING_AMOUNT_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }
}
