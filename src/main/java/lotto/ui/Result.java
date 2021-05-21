package lotto.ui;

import static lotto.common.PrizeEnum.*;

import java.util.Map;

import lotto.common.PrintMessage;
import lotto.shop.Money;

public class Result {
    public static void resultIncome(Map<Integer, Integer> matchAnswer, Money money) {
        int total = 0;
        FOURTH.print(matchAnswer);
        total += FOURTH.prize(matchAnswer);
        THIRD.print(matchAnswer);
        total += THIRD.prize(matchAnswer);
        SECOND.print(matchAnswer);
        total += SECOND.prize(matchAnswer);
        FIRST.print(matchAnswer);
        total += FIRST.prize(matchAnswer);
        System.out.printf(PrintMessage.INCOME_PREFIX.message() + "%.2f" + PrintMessage.INCOME_POSTFIX.message() + "%n", (float) total / money.amount());
    }
}
