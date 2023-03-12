package lotto.ui;

import java.util.Scanner;

public class LottoRequest {
    private final int money;

    public LottoRequest(int money) {
        this.money = money;
    }

    public static LottoRequest inputBuyingPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        int money = sc.nextInt();
        sc.nextLine();
        return new LottoRequest(money);
    }

    public int getMoney() {
        return money;
    }
}
