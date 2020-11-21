package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    FAIL(new RankMatcher(0, false), 0),
    FIFTH(new RankMatcher(3, false), 5_000),
    FOURTH(new RankMatcher(4, false), 50_000),
    THIRD(new RankMatcher(5, false), 1_500_000),
    SECOND(new RankMatcher(5, true), 30_000_000),
    FIRST(new RankMatcher(6, false), 2_000_000_000);

    private final int price;
    private RankMatcher rankMatcher;

    WinningRank(RankMatcher rankMatcher, int price) {
        this.rankMatcher = rankMatcher;
        this.price = price;
    }

    public static WinningRank getWinningRank(RankMatcher rankMatcher) {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.getRankMatcher().equals(rankMatcher))
                .findAny()
                .orElse(WinningRank.FAIL);
    }

    public int getPrice() {
        return price;
    }

    public boolean isFail() {
        return this == WinningRank.FAIL;
    }

    public int getTotalPrice(int num) {
        return price * num;
    }

    public RankMatcher getRankMatcher() {
        return rankMatcher;
    }

    public int getSameNumberNum() {
        return rankMatcher.getSameNumberCount();
    }
}
