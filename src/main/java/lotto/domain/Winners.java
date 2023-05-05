package lotto.domain;

public class Winners {
    private final int matchingBall;
    private final boolean bonusBallMatch;

    public Winners(int matchingBall, boolean bonusBallMatch) {
        this.matchingBall = matchingBall;
        this.bonusBallMatch = bonusBallMatch;
    }

    public Prize providePrize() {
        Prize prize = Prize.valueOf(this.matchingBall);
        if (isSecondPrize(prize)) {
            return Prize.SECOND_PLACE;
        }

        return prize;
    }

    public boolean isSecondPrize(Prize prize) {
        return prize == Prize.THIRD_PLACE && bonusBallMatch;

    }
}
