package lotto;

import java.util.*;

public enum WinInfo {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    public static final List<WinInfo> WIN_INFOS = Collections.unmodifiableList(Arrays.asList(THREE, FOUR, FIVE, SIX));

    private final int matchCount;
    private final int prizeMoney;

    WinInfo(int matchCount, int prizeMoney) {

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
