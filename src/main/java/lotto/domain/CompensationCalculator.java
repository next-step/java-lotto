package lotto.domain;

import lotto.common.MatchHits;
import lotto.common.Ranking;

public class CompensationCalculator {

    public static final int THREE_MATCH = 3;
    public static final int FOUR_MATCH = 4;
    public static final int FIVE_MATCH = 5;
    public static final int SIX_MATCH = 6;

    public int calculateFromMatchCount(MatchHits matchHits) {

        int threeMatchHits = matchHits.getThreeMatchHits();
        int fourMatchHits = matchHits.getFourMatchHits();
        int fiveMatchHits = matchHits.getFiveMatchHits();
        int sixMatchHits = matchHits.getSixMatchHits();

        return getCompensation(threeMatchHits, fourMatchHits, fiveMatchHits, sixMatchHits);
    }

    private int getCompensation(int threeMatchHits, int fourMatchHits, int fiveMatchHits, int sixMatchHits) {
        return getCompensation(THREE_MATCH, threeMatchHits) +
                getCompensation(FOUR_MATCH, fourMatchHits) +
                getCompensation(FIVE_MATCH, fiveMatchHits) +
                getCompensation(SIX_MATCH, sixMatchHits);
    }

    private int getCompensation(int matchCount, int matchHits) {
        return Ranking.getCompensationBy(matchCount) * matchHits;
    }
}
