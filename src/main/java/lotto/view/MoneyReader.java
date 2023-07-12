package lotto.view;

import java.util.Scanner;
import lotto.domain.Money;

public class MoneyReader {

    private static final String INPUT_MONEY_GUIDE_MESSAGE = "구입 금액을 입력해주세요.";

    public Money readMoney() {
        System.out.println(INPUT_MONEY_GUIDE_MESSAGE);

        Scanner scanner = new Scanner(System.in);

        return new Money(scanner.nextLine());
    }
}
