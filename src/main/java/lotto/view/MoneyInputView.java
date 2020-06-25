package lotto.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class MoneyInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final BigDecimal money;

    private MoneyInputView(BigDecimal money) {
        this.money = money;
    }

    public static MoneyInputView enterMoney() {
        return new MoneyInputView(getInput());
    }

    private static BigDecimal getInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextBigDecimal();
    }

    public BigDecimal getMoney() {
        return money;
    }

}
