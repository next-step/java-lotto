package lotto.view;

import lotto.wrapper.InputString;
import lotto.wrapper.Money;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Money inputAmount() {
        int amount = scanner.nextInt();
        return new Money(amount);
    }
}
