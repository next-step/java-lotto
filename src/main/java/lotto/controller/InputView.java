package lotto.controller;

import lotto.model.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입 금액을 입력해주세요");
        return new Money(SCANNER.nextInt());
    }
}
