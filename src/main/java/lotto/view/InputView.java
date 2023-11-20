package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final int MONEY_UNIT = 1000;
    private static final int ZERO = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static Integer start() {
        System.out.println("구입 금액을 입력해주세요");
        int money = scanner.nextInt();
        if (money % MONEY_UNIT != ZERO) {
            throw new IllegalArgumentException("로또 구매는 1000원 단위로 구매할 수 있습니다.");
        }
        System.out.println(money / MONEY_UNIT + "개를 구매했습니다.");
        return money / MONEY_UNIT;
    }
}
