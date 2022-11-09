package lotto.view;

import lotto.domain.Money;
import lotto.strategy.ManualNumberStrategy;

import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(SCANNER.nextLine());
    }

    public static ManualNumberStrategy inputWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new ManualNumberStrategy(SCANNER.nextLine());
    }
}
