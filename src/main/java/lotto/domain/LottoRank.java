package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    THREE_NUMBER_CORRECT(3, 5000L),
    FOUR_NUMBER_CORRECT(4, 50000L),
    FIVE_NUMBER_CORRECT(5, 1500000L),
    SIX_NUMBER_CORRECT(6, 2000000000L);

    private final int correctCount;
    private final long winnings;

    LottoRank(int correctCount, long winnings) {
        this.correctCount = correctCount;
        this.winnings = winnings;
    }

    public static Optional<LottoRank> findByCorrectCount(int correctCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctCount == correctCount)
                .findFirst();
    }

    public long getWinnings() {
        return winnings;
    }
}