package step2;

import java.util.Scanner;

public class InputView {

    private static final String REQUIRE_PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askPurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT_MSG);
        return scanner.nextLine();
    }
}
