package lotto.view;

import lotto.domain.Price;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this(System.in);
    }

    InputView(final InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public Price inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return new Price(scanner.nextInt());
    }
}
