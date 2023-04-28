package lotto.view;

import lotto.domain.LottoInfo;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final int money;

    public InputView(int money) {
        System.out.println(money / LottoInfo.PRICE + "개를 구매했습니다.");
        this.money = money;
    }

    public static InputView buy() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputView(SCANNER.nextInt());
    }

    public int getMoney() {
        return this.money;
    }
}
