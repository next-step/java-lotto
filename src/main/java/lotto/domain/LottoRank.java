package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000),
    NO_MATCH(0, 0)
    ;

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean match(WinningLotto winningLotto, Lotto lotto) {
        return this.getMatchCount() <= lotto.getMatchCount(winningLotto);
    }

    public static LottoRank getRank(WinningLotto winningLotto, Lotto lotto) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> rank.match(winningLotto, lotto))
            .max(Comparator.comparingInt(LottoRank::getPrizeMoney))
            .orElseThrow();
    }

}

