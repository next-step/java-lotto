package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return SCANNER.nextInt();
    }
}
