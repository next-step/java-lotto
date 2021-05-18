package lotto.core;


public class Round {
    private final int round;
    private SixBall sixBall;

    public Round(SixBall sixBall) {
        this(0, sixBall);
    }

    public Round(int round, SixBall sixBall) {
        this.round = round;
        this.sixBall = sixBall;
    }

    @Override
    public String toString() {
        return String.format("%d회차 당첨번호 : %s", round, sixBall);
    }
}
