package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    LOSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000)
    ;

    private final int matchCount;
    private final long winAmount;

    LottoRank(int matchCount, int winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    public int matchCount() {
        return matchCount;
    }

    public long winAmount() {
        return winAmount;
    }

    public static LottoRank of(int matchCount) {
        if (isLose(matchCount)) {
            return LOSE;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("매칭 숫자에 해당하는 등수가 존재하지 않습니다."));
    }

    private static boolean isLose(int matchCount) {
        return matchCount >= LOSE.matchCount() && matchCount < FIFTH.matchCount();
    }
}
