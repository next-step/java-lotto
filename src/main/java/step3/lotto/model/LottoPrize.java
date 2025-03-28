package step3.lotto.model;

import java.util.Map;

public enum LottoPrize {

    FIRST(new LottoMatchCount(6)),
    THIRD(new LottoMatchCount(5)),
    FOURTH(new LottoMatchCount(4)),
    FIFTH(new LottoMatchCount(3));

    private final LottoMatchCount lottoMatchCount;

    LottoPrize(LottoMatchCount lottoMatchCount) {
        this.lottoMatchCount = lottoMatchCount;
    }

    private static final Map<LottoPrize, LottoMatchCount> MATCH_COUNT = Map.of(
        FIRST, FIRST.lottoMatchCount,
        THIRD, THIRD.lottoMatchCount,
        FOURTH, FOURTH.lottoMatchCount,
        FIFTH, FIFTH.lottoMatchCount
    );

    private static final Map<Count, Money> PRIZE_MONEY = Map.of(
        FIRST.lottoMatchCount, new Money(2_000_000_000L),
        THIRD.lottoMatchCount, new Money(1_500_000L),
        FOURTH.lottoMatchCount, new Money(50_000L),
        FIFTH.lottoMatchCount, new Money(5_000L)
    );

    public static LottoMatchCount matchCountOf(LottoPrize lottoPrize) {
        return MATCH_COUNT.get(lottoPrize);
    }

    public static Money moneyOf(Count count) {
        return PRIZE_MONEY.get(count);
    }

    public static Money moneyOf(LottoPrize lottoPrize) {
        return PRIZE_MONEY.get(MATCH_COUNT.get(lottoPrize));
    }

}
