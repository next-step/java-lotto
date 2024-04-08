package view;

import domain.Money;
import domain.WinStatus;

import java.util.Scanner;

public class LottoInput {
    private final static Scanner input = new Scanner(System.in);
    public static Money money;

    public Money buyCash() {
        System.out.println("구입금액을 입력해 주세요.");
        money = new Money(input.nextInt());
        return money;
    }

    public int manualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        // 안에서 하면 의존적이지는 않은가?
        return input.nextInt();
    }
}
