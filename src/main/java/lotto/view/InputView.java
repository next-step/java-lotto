package lotto.view;

import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String winningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
