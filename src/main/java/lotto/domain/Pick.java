package lotto.domain;

import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;

public class Pick {
    private PickType type;
    private LottoBalls balls;
    private Rank rank;

    public Pick() {
    }

    public Pick(PickType pickType, LottoBalls balls) {
        this.type = pickType;
        this.balls = balls;
    }

    public LottoBalls getBalls() {
        return balls;
    }

    public PickType getType() {
        return type;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int checkWinningBallCount(LottoBalls winningBalls) {
        return balls.containsCount(winningBalls);
    }
}
