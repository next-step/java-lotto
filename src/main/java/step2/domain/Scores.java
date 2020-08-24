package step2.domain;

public class Scores {
    private ScoreType scoreType;

    public Scores(int targetNumber, boolean hasBonusNumber) {
        this.scoreType = ScoreType.getScore(targetNumber, hasBonusNumber);
    }

    public ScoreType getScore() {
        return scoreType;
    }
}
