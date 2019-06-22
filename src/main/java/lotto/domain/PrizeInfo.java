package lotto.domain;

import java.util.*;

public enum PrizeInfo {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    public static final List<PrizeInfo> PRIZE_INFOS = Collections.unmodifiableList(Arrays.asList(THREE, FOUR, FIVE, SIX));

    private final int matchCount;
    private final int prizeMoney;

    PrizeInfo(int matchCount, int prizeMoney) {

        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {

        return matchCount;
    }

    public int getPrizeMoney() {

        return prizeMoney;
    }
}
