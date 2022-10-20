package lotto.view.money;

import java.util.Scanner;

public class MoneyInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static long money() {
        try {
            return scanner.nextLong();
        } catch (Exception e) {
            MoneyOutput.moneyInputError();
        }
        return money();
    }
}
