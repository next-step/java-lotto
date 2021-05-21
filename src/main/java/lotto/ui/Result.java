package lotto.ui;

import static lotto.common.PrizeEnum.*;

import java.util.Map;

import lotto.common.PrintMessage;
import lotto.shop.Money;

public class Result {
    public static void resultIncome(Map<Integer, Integer> matchAnswer, Money money) {
        int total = 0;
        FOURTH.print(matchAnswer.getOrDefault(FOURTH.answer(), 0));
        total += FOURTH.prize(matchAnswer.getOrDefault(FOURTH.answer(), 0));
        THIRD.print(matchAnswer.getOrDefault(THIRD.answer(), 0));
        total += THIRD.prize(matchAnswer.getOrDefault(THIRD.answer(), 0));
        SECOND.print(matchAnswer.getOrDefault(SECOND.answer(), 0));
        total += SECOND.prize(matchAnswer.getOrDefault(SECOND.answer(), 0));
        FIRST.print(matchAnswer.getOrDefault(FIRST.answer(), 0));
        total += FIRST.prize(matchAnswer.getOrDefault(FIRST.answer(), 0));
        System.out.printf(PrintMessage.INCOME_PREFIX.message() + "%.2f" + PrintMessage.INCOME_POSTFIX.message() + "%n", (float) total / money.amount());
    }
}
