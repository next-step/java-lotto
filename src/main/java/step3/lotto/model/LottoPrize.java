package step3.lotto.model;

import java.util.Map;

public enum LottoPrize {

    FIRST(new LottoMatchCount(6), new LottoMatchBonusCount(0)),
    SECOND(new LottoMatchCount(5), new LottoMatchBonusCount(1)),
    THIRD(new LottoMatchCount(5), new LottoMatchBonusCount(0)),
    FOURTH(new LottoMatchCount(4)),
    FIFTH(new LottoMatchCount(3));

    private final LottoMatchCount lottoMatchCount;
    private LottoMatchBonusCount lottoMatchBonusCount = null;

    LottoPrize(LottoMatchCount lottoMatchCount) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoMatchBonusCount = null;
    }

    LottoPrize(LottoMatchCount lottoMatchCount, LottoMatchBonusCount lottoMatchBonusCount) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoMatchBonusCount = lottoMatchBonusCount;
    }

    private static final Map<LottoPrize, LottoMatchCount> MATCH_COUNT = Map.of(
        FIRST, FIRST.lottoMatchCount,
        SECOND, SECOND.lottoMatchCount,
        THIRD, THIRD.lottoMatchCount,
        FOURTH, FOURTH.lottoMatchCount,
        FIFTH, FIFTH.lottoMatchCount
    );

    private static final Map<LottoPrize, LottoMatchBonusCount> BONUS_MATCH_COUNT = Map.of(
        FIRST, new LottoMatchBonusCount(0),
        SECOND, new LottoMatchBonusCount(1),
        THIRD, new LottoMatchBonusCount(0)
    );

    private static final Map<LottoPrize, Money> PRIZE_MONEY = Map.of(
        FIRST, new Money(2_000_000_000L),
        SECOND, new Money(30_000_000L),
        THIRD, new Money(1_500_000L),
        FOURTH, new Money(50_000L),
        FIFTH, new Money(5_000L)
    );

    public static LottoPrize of(LottoMatchCount lottoMatchCount, LottoMatchBonusCount lottoMatchBonusCount) {
        if (lottoMatchCount.equals(FIRST.lottoMatchCount)) {
            return FIRST;
        }
        if (lottoMatchCount.equals(SECOND.lottoMatchCount)) {
            if (lottoMatchBonusCount.equals(SECOND.lottoMatchBonusCount)) {
                return SECOND;
            }
        }
        if (lottoMatchCount.equals(THIRD.lottoMatchCount)) {
            return THIRD;
        }
        if (lottoMatchCount.equals(FOURTH.lottoMatchCount)) {
            return FOURTH;
        }
        if (lottoMatchCount.equals(FIFTH.lottoMatchCount)) {
            return FIFTH;
        }
        return null;
    }

    public static LottoMatchCount matchCountOf(LottoPrize lottoPrize) {
        return MATCH_COUNT.get(lottoPrize);
    }

    public static LottoMatchBonusCount bonusMatchCountOf(LottoPrize lottoPrize) {
        return BONUS_MATCH_COUNT.get(lottoPrize);
    }

    public static Money moneyOf(LottoPrize lottoPrize) {
        return PRIZE_MONEY.get(lottoPrize);
    }

}
