package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해주세요.";
    private static final String LAST_WEEK_WIN_LOTTO_MESSAGE = "지난주 당첨번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println(MESSAGE_PURCHASE_PRICE);
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String inputLastWeekWinLotto() {
        System.out.println(LAST_WEEK_WIN_LOTTO_MESSAGE);
        return this.scanner.nextLine();
    }

    public int bonusBall() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return this.scanner.nextInt();
    }
}
