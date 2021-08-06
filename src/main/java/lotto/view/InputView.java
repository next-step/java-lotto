package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String FIRST_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int askPurchaseAmount() {
        System.out.printf(FIRST_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

}
