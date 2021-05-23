package lotto.ui;

import java.util.Map;

import lotto.common.PrintMessage;
import lotto.shop.Money;

public class Result {
    public static void resultIncome(Map<Integer, Integer> matchAnswer, Money money) {
        int total = 0;
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            total += prizeValue.income(matchAnswer);
            println(prizeValue.answer(), prizeValue.prize(), matchAnswer);
        }
        System.out.printf(MessageEnum.INCOME_PREFIX.message() + "%.2f" + MessageEnum.INCOME_POSTFIX.message() + "%n", (float) total / money.amount());
    }

    private static void println(int answer, int prize, Map<Integer, Integer> matchAnswer) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", answer, prize, matchAnswer.getOrDefault(answer, 0));
    }
}
