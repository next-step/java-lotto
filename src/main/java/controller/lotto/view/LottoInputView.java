package controller.lotto.view;

import domain.common.Money;

import java.util.Scanner;

public class LottoInputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static Money createMoneyViewThenGetMoney() {
        System.out.println("구입금액을 입력해주세요");
        long number = scanner.nextLong();
        scanner.nextLine();
        return Money.create(number);


    }
}
