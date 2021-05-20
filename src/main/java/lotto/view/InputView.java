package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
