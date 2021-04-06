package lotto.domain.stats;

public class Score {
    private final long score;
    private final long matchingBallCount;
    private final long prizeAmount;
    private final long winners;

    public Score(long score, long matchingBallCount, long prizeAmount, long winners) {
        this.score = score;
        this.matchingBallCount = matchingBallCount;
        this.prizeAmount = prizeAmount;
        this.winners = winners;
    }

    public long getScore() {
        return score;
    }

    public long getMatchingBallCount() {
        return matchingBallCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public long getWinners() {
        return winners;
    }
}
