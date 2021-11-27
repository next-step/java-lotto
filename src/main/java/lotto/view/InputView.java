package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해주세요.";
    private static String LAST_WEEK_WIN_LOTTO_MESSAGE = "지난주 당첨번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Money inputMoney() {
        System.out.println(MESSAGE_PURCHASE_PRICE);
        return new Money(this.scanner.nextLine());
    }

    public Lotto inputLastWeekWinLotto() {
        return Lotto.from(this.scanner.nextLine());
    }
}
