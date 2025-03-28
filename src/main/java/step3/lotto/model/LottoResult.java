package step3.lotto.model;

import java.util.Map;
import java.util.stream.LongStream;

public class LottoResult {

    private final Map<LottoMatchCount, Count> TICKET_COUNT = Map.of(
        LottoPrize.matchCountOf(LottoPrize.FIFTH), new Count(0),
        LottoPrize.matchCountOf(LottoPrize.FOURTH), new Count(0),
        LottoPrize.matchCountOf(LottoPrize.THIRD), new Count(0),
        LottoPrize.matchCountOf(LottoPrize.FIRST), new Count(0)
    );

    public void reflect(LottoMatchCount lottoMatchCount) {
        TICKET_COUNT.get(lottoMatchCount).increase();
    }

    public Count ticketCountOf(LottoPrize lottoPrize) {
        return TICKET_COUNT.get(LottoPrize.matchCountOf(lottoPrize));
    }

    public Money prizeMoney() {
        Money prizeMoney = new Money("0");

        LongStream.range(0, TICKET_COUNT.get(LottoPrize.matchCountOf(LottoPrize.FIRST)).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FIRST)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.matchCountOf(LottoPrize.THIRD)).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.THIRD)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.matchCountOf(LottoPrize.FOURTH)).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FOURTH)));
        LongStream.range(0, TICKET_COUNT.get(LottoPrize.matchCountOf(LottoPrize.FIFTH)).value())
            .forEach(i -> prizeMoney.add(LottoPrize.moneyOf(LottoPrize.FIFTH)));

        return prizeMoney;
    }

}
