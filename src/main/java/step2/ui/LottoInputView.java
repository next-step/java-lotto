package step2.ui;

import java.util.Scanner;

public final class LottoInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    public static int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return SCANNER.nextInt();
    }
}
