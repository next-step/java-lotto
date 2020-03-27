package lotto.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private final Scanner scanner;

    public InputView(final InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return scanner.nextInt();
    }
}
