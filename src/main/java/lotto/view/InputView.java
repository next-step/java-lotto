package lotto.view;

import lotto.wrapper.Money;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Money inputAmount() {
        int amount = scanner.nextInt();
        if( amount < 1000) {
            throw new IllegalArgumentException("복권은 1000원 부터 구매 가능합니다.");
        }
        return new Money(amount);
    }
}
