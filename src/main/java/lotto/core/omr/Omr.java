package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;

public class Omr {
    private final SixBall sixBall;

    protected Omr(SixBall sixBall) {
        this.sixBall = sixBall;
    }

    protected Rank grade(Round round) {
        int count = (int) round.stream()
                .filter(sixBall::contains)
                .count();

        boolean matchBonus = sixBall.contains(round.getBonusBall());

        return Rank.valueOf(count, matchBonus);
    }

    @Override
    public String toString() {
        return sixBall.toString();
    }
}
