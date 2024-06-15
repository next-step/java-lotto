package lotto.view;

import java.util.Scanner;
import java.util.function.Supplier;

class InputView {
    private final Scanner scan = new Scanner(System.in);

    protected <T> T process(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception ex) {
                System.out.printf("[ERROR] %s\n", ex.getMessage());
            }
        }
    }

    protected String inputString() {
        return scan.nextLine();
    }

    protected int inputNumber() {
        return Integer.parseInt(inputString());
    }
}
