package step2.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String INSERT_MONEY = "구입 금액을 입력해 주세요.";
    private final static String INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)";

    private InputView() {
    }

    public static long inputMoney() {
        System.out.println(INSERT_MONEY);
        return scanner.nextLong();
    }

    public static String inputLastWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);
        return scanner.next();
    }
}