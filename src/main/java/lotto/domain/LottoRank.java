package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    FIFTH(3, 5000L),
    FOURTH(4, 50000L),
    THIRD(5, 1500000L),
    SECOND(5, 30000000L),
    FIRST(6, 2000000000L);

    private final int correctCount;
    private final long winnings;

    LottoRank(int correctCount, long winnings) {
        this.correctCount = correctCount;
        this.winnings = winnings;
    }

    public static Optional<LottoRank> findByCorrectCount(int correctCount, boolean isBonus) {
        if (isBonus && correctCount == 5) {
            return Optional.of(SECOND);
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctCount == correctCount)
                .findFirst();
    }

    public long getWinnings() {
        return winnings;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}