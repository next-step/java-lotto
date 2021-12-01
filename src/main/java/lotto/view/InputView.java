package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputAmount() {
        return intInput("구입금액을 입력해 주세요.");
    }

    private static int intInput(String message) {
        print(message);
        return scanner.nextInt();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
