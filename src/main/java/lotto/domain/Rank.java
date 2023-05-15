package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(2, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank of(Lotto lotto, WinNumbers winNumbers) {
        if (isSecond(lotto, winNumbers)) {
            return Rank.SECOND;
        }
        if (isThird(lotto, winNumbers)) {
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == winNumbers.getMatchCount(lotto))
                .findFirst()
                .orElse(Rank.LOSE);
    }

    private static boolean isSecond(Lotto lotto, WinNumbers winNumbers) {
        return winNumbers.getMatchCount(lotto) == 5 && winNumbers.isBonusIncludedIn(lotto);
    }

    private static boolean isThird(Lotto lotto, WinNumbers winNumbers) {
        return winNumbers.getMatchCount(lotto) == 5 && !winNumbers.isBonusIncludedIn(lotto);
    }

    public long getPrize() {
        return this.prize;
    }
}
