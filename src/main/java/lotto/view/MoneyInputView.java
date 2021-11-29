package lotto.view;

import java.util.Scanner;

public class MoneyInputView {
    private int money;

    public void setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = new Scanner(System.in).nextInt();
    }

    public int getMoney() {
        return this.money;
    }
}
