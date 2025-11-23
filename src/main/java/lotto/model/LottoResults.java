package lotto.model;

import java.util.Objects;

public class LottoResults {
    private final int countThreeMatches;
    private final int countFourMatches;
    private final int countFiveMatches;
    private final int countSixMatches;
    public final static int PRIZE_THREE_MATCHES = 5000;
    public final static int PRIZE_FOUR_MATCHES = 50000;
    public final static int PRIZE_FIVE_MATCHES = 1500000;
    public final static int PRIZE_SIX_MATCHES = 2000000000;

    public LottoResults(int countThreeMatches, int countFourMatches, int countFiveMatches, int countSixMatches) {
        this.countThreeMatches = countThreeMatches;
        this.countFourMatches = countFourMatches;
        this.countFiveMatches = countFiveMatches;
        this.countSixMatches = countSixMatches;
    }

    public int threeMatches() {
        return countThreeMatches;
    }

    public int fourMatches() {
        return countFourMatches;
    }

    public int fiveMatches() {
        return countFiveMatches;
    }

    public int sixMatches() {
        return countSixMatches;
    }

    public long getPrizeValue() {
        return (long) countThreeMatches * PRIZE_THREE_MATCHES
                + (long) countFourMatches * PRIZE_FOUR_MATCHES
                + (long) countFiveMatches * PRIZE_FIVE_MATCHES
                + (long) countSixMatches * PRIZE_SIX_MATCHES;
    }

    public double getReturnRate(Budget budget) {
        long totalPrize = getPrizeValue();
        return budget.getReturnRate(totalPrize);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return countThreeMatches == that.countThreeMatches && countFourMatches == that.countFourMatches && countFiveMatches == that.countFiveMatches && countSixMatches == that.countSixMatches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countThreeMatches, countFourMatches, countFiveMatches, countSixMatches);
    }
}
