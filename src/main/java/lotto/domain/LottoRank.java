package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    LOSE(0, 0),
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final long winAmount;

    LottoRank(int matchCount, long winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public static LottoRank getEnum(int matchCount) {
        if (isLose(matchCount)) {
            return LOSE;
        }
        Optional<LottoRank> find = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst();
        if (find.isPresent()) {
            return find.get();
        }
        throw new IllegalArgumentException();
    }

    private static boolean isLose(int matchCount) {
        return matchCount >= LOSE.getMatchCount() && matchCount < FIFTH.getMatchCount();
    }
}
