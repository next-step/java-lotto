package view;

import domain.WinStatus;

import java.util.Scanner;

public class LottoInput {
    private final static Scanner input = new Scanner(System.in);
    private final int LOTTO_PRICE = 1000;

    public int buyCash() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = input.nextInt();
        correctMoney(money);
        return money / 1000;
    }

    private void correctMoney(int money) {
        if (money < 0 || money % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("잘못된 구입금액 입니다");
        System.out.println(money / LOTTO_PRICE + "개를 구매했습니다.");
    }
}
