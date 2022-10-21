package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {

    }

    public static int inputAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
