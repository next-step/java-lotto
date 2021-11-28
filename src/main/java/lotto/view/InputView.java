package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해주세요.";
    private static String LAST_WEEK_WIN_LOTTO_MESSAGE = "지난주 당첨번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println(MESSAGE_PURCHASE_PRICE);
        return this.scanner.nextInt();
    }

    public String inputLastWeekWinLotto() {
        System.out.println(LAST_WEEK_WIN_LOTTO_MESSAGE);
        return this.scanner.nextLine();
    }
}
