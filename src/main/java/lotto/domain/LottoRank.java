package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, Money.won(2000000000)),
    SECOND(5, Money.won(1500000)),
    THIRD(4, Money.won(50000)),
    FOURTH(3, Money.won(5000)),
    FIFTH(2, Money.ZERO),
    SIXTH(1,  Money.ZERO),
    SEVENTH(0,  Money.ZERO);

    private static Map<Integer, LottoRank> rankByMatchCount = Stream.of(LottoRank.values())
            .collect(Collectors.toMap(lottoPrize -> lottoPrize.matchCount, lottoPrize -> lottoPrize));

    private final int matchCount;
    private final Money prizeMoney;

    LottoRank(int matchCount, Money prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int matchCount) {
        if (matchCount > FIRST.matchCount || matchCount < SEVENTH.matchCount) {
            throw new IllegalArgumentException("일치 숫자는 0이상 6이하 이어야 한다.");
        }
        return rankByMatchCount.get(matchCount);
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money calculatePrizeMoney(int prizeCount) {
        return prizeMoney.times(prizeCount);
    }
}
