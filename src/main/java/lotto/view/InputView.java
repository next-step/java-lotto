package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseValue() {
        System.out.println("구입 금액을 입력해 주세요.");
        String value = SCANNER.nextLine();
        return Integer.parseInt(value) / 1000;
    }

    public static String inputPrevWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }
}
