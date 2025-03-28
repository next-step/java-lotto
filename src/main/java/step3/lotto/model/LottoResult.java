package step3.lotto.model;

import java.util.Map;
import java.util.stream.LongStream;

public class LottoResult {

    private final Map<LottoPrize, Count> TICKET_COUNT = Map.of(
        LottoPrize.FIFTH, new Count(0),
        LottoPrize.FOURTH, new Count(0),
        LottoPrize.THIRD, new Count(0),
        LottoPrize.SECOND, new Count(0),
        LottoPrize.FIRST, new Count(0)
    );

    public void reflect(LottoPrize lottoPrize) {
        TICKET_COUNT.get(lottoPrize).increase();
    }

    public Count ticketCountOf(LottoPrize lottoPrize) {
        return TICKET_COUNT.get(lottoPrize);
    }

    public Money prizeMoney() {
        Money prizeMoney = new Money("0");

        LongStream.range(0, TICKET_COUNT.get(LottoPrize.FIRST).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FIRST)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.SECOND).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.SECOND)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.THIRD).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.THIRD)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.FOURTH).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FOURTH)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.FIFTH).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FIFTH)));

        return prizeMoney;
    }

}
