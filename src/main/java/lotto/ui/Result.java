package lotto.ui;

import lotto.enums.MessageEnum;
import lotto.enums.PrizeEnum;
import lotto.lotto.MatchedAnswer;
import lotto.shop.Money;

public class Result {
    public static void resultIncome(MatchedAnswer matchAnswer, Money money) {
        int total = 0;
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            total += prizeValue.income(matchAnswer);
            println(prizeValue.answer(), prizeValue.prize(), matchAnswer);
        }
        System.out.printf(MessageEnum.INCOME_PREFIX.message() + "%.2f" + MessageEnum.INCOME_POSTFIX.message() + "%n", (float) total / money.amount());
    }

    private static void println(int answer, int prize, MatchedAnswer matchAnswer) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", answer, prize, matchAnswer.count(answer));
    }
}
