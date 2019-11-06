package step2.View;

import java.util.Scanner;

public class InputView {
    private static final String AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static String[] getWinningNumbers() {
        scanner.nextLine();
        System.out.println(WINNING_NUMBER);
        return scanner.nextLine().split(",");
    }

    public static int buyTickets() {
        System.out.println(AMOUNT);
        return scanner.nextInt();
    }
}
