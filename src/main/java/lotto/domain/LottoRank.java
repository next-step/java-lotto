package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {
    MATCH_3(3, new Money(5000)),
    MATCH_4(4, new Money(50000)),
    MATCH_5(5, new Money(1500000)),
    MATCH_6(6, new Money(2000000000)),
    NO_MATCH(0, Money.ZERO)
    ;

    private final int matchCount;
    private final Money prize;

    LottoRank(int matchCount, Money prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrize() {
        return prize;
    }

    public boolean match(WinningLotto winningLotto, Lotto lotto) {
        return this.getMatchCount() <= lotto.getMatchCount(winningLotto);
    }

    public static LottoRank getRank(WinningLotto winningLotto, Lotto lotto) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> rank.match(winningLotto, lotto))
            .max(Comparator.comparing(LottoRank::getPrize))
            .orElseThrow();
    }

}

