package lotto.ui;

import lotto.domain.shop.Money;

import java.util.Scanner;

public class BuyInputView {
    private Money money;

    protected BuyInputView(long moneyValue) {
        this.money = new Money(moneyValue);
    }

    public static BuyInputView createByConsole(Scanner scanner) {
        System.out.println("구매금액을 입력해주세요");
        return new BuyInputView(scanner.nextLong());
    }

    public Money getMoney() {
        return money;
    }
}
