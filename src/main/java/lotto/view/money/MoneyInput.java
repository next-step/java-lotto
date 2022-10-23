package lotto.view.money;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoneyInput {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static long money() {
        try {
            return Long.parseLong(bufferedReader.readLine());
        } catch (Exception e) {
            MoneyOutput.moneyInputError();
        }
        return money();
    }
}
