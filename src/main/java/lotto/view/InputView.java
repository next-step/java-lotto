package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static long inputPriceForBuying() {
        System.out.println("구입금액을 입력해주세요.");
        return SCANNER.nextLong();
    }

    public static String inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }
}
