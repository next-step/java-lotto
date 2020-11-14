package lotto.view;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {
    public static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;

    private InputView() {
    }

    public static int getMoney() {
        out.println(GET_MONEY_MESSAGE);
        return scanner.nextInt();
    }
}
