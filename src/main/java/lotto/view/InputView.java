package lotto.view;

import lotto.domain.LottoRule;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private final int money;

    public InputView(int money) {
        System.out.println(money / LottoRule.PRICE + "개를 구매했습니다.");
        this.money = money;
    }

    public static InputView buy() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputView(scanner.nextInt());
    }

    public int money() {
        return this.money;
    }

    public String winLottoInfo() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
