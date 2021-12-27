package step2;

import java.util.Scanner;

public class InputView {

    private static final String REQUIRE_PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private static final String REQUIRE_LAST_WINNING_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askPurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT_MSG);
        return scanner.nextLine();
    }

    public String askLastWeekWinningNumber() {
        System.out.println(REQUIRE_LAST_WINNING_NUMBER_MSG);
        return scanner.nextLine();
    }
}
