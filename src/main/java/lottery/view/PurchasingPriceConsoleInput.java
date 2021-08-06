package lottery.view;

import java.util.Scanner;

public class PurchasingPriceConsoleInput {

    private static final String PURCHASING_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String askPurchasingPrice() {
        System.out.println(PURCHASING_AMOUNT_QUESTION);
        return scanner.nextLine();
    }
}
