package view;

import domain.WinStatus;

import java.util.Scanner;

public class LottoInput {
    private final Scanner input = new Scanner(System.in);


    public int buyCash() {
        int money = input.nextInt();
        correctMoney(money);
        return money;
    }

    private void correctMoney(int money) {
        if (money < 0 || money % 1000 != 0)
            throw new IllegalArgumentException("잘못된 구입금액 입니다");
        System.out.println(money / 1000 + "개를 구매했습니다.");
    }
}
