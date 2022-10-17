package lotto.view.money;

import lotto.domain.Money.ImmutableMoney;

import java.util.Scanner;

public class MoneyInput {

    public static ImmutableMoney money() {
        Scanner scanner = new Scanner(System.in);
        try {
            return new ImmutableMoney(scanner.nextInt());
        } catch (Exception e) {
            MoneyOutput.moneyInputError();
        }
        return money();
    }
}
