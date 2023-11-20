package step2.lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    LOSE(0, 0);

    private final int matchNumber;
    private final int prizeAmount;

    LottoRank(int matchNumber, int prizeAmount) {
        this.matchNumber = matchNumber;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank matchLottoRank(final int matchNumberCount) {
        return Arrays.stream(LottoRank.values())
            .filter(value -> value.matches(matchNumberCount))
            .findFirst()
            .orElse(LOSE);
    }

    private boolean matches(int count) {
        return this.matchNumber == count;
    }

    public long lottoRankTotalPrizeAmount(final int scoreCount) {
        return this.prizeAmount * scoreCount;
    }

}
