package automaticlotto.domain;

import java.util.stream.Stream;

public enum LottoRanking {

    MISMATCH(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    final private int winningCount;
    final private int compensation;

    LottoRanking(int winningCount, int compensation) {
        this.winningCount = winningCount;
        this.compensation = compensation;
    }

    public int getCompensation() {
        return this.compensation;
    }

    static LottoRanking findLottoRanking(int value) {
        return Stream.of(values())
                .filter(lottoRanking -> lottoRanking.winningCount == value)
                .findFirst()
                .orElse(MISMATCH);
    }
}
