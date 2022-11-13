package automaticlotto.domain;

import java.util.stream.Stream;

public enum LottoRanking {

    MISMATCH(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int winningCount;
    private int compensation;

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
