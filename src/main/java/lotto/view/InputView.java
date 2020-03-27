package lotto.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(final InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public int inputPrice() {
        return scanner.nextInt();
    }
}
