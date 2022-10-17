package lotto.view;

import lotto.util.NumberUtil;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return NumberUtil.getPositiveInteger(SCANNER.nextLine());
    }
}
