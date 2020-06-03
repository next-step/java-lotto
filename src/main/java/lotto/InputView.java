package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.next();
    }

    public String winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }
}
