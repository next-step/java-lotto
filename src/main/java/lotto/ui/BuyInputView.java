package lotto.ui;

import java.util.Scanner;

public class BuyInputView {
    private long money;

    protected BuyInputView(long money) {
        this.money = money;
    }

    public static BuyInputView createByConsole(Scanner scanner) {
        System.out.println("구매금액을 입력해주세요");
        return new BuyInputView(scanner.nextLong());
    }

    public long getMoney() {
        return money;
    }
}
