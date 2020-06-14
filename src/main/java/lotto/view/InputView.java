package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final double money;

    private InputView(double money) {
        this.money = money;
    }

    public static InputView enterInput() {
        return new InputView(enterMoney());
    }

    private static double enterMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextDouble();
    }

    public double getMoney() {
        return money;
    }
}
