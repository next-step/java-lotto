package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_START_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static int getMoney() {
        System.out.println(INPUT_START_MESSAGE);
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
}
