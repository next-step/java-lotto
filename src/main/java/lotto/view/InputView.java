package lotto.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final String REQUIRE_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUIRE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getMoney() {
        print(REQUIRE_MONEY);
        return parseInt(getInput());
    }

    public static String getWinningNumber() {
        print("");
        print(REQUIRE_WINNING_NUMBER);
        return getInput();
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
