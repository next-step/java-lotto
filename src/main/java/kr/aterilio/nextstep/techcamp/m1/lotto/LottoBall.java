package kr.aterilio.nextstep.techcamp.m1.lotto;

public class LottoBall implements Comparable<LottoBall> {

    public static final int MIN = 1;
    public static final int MAX = 45;

    public static final String MSG_ERR_OUT_OF_RANGE = "로또를 구성하는 수가 범위를 벗어났습니다.";

    private final int ball;

    public LottoBall(int ball) {
        validateRange(ball);
        this.ball = ball;
    }

    private void validateRange(int ball) {
        if (ball < MIN || ball > MAX) {
            throw new IllegalArgumentException(MSG_ERR_OUT_OF_RANGE);
        }
    }

    public int number() {
        return ball;
    }

    public boolean isEqualTo(int number) {
        return ball == number;
    }

    public boolean findOrDefault(int number, boolean defaultValue) {
        if (isEqualTo(number)) {
            return true;
        }
        return defaultValue;
    }

    @Override
    public int compareTo(LottoBall that) {
        return Integer.compare(this.ball, that.ball);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoBall)) {
            return false;
        }
        return this.ball == ((LottoBall) obj).ball;
    }
}
