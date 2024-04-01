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
}
