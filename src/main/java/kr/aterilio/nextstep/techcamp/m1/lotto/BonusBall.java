package kr.aterilio.nextstep.techcamp.m1.lotto;

public class BonusBall {

    private final int bonusBall;

    public BonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
        validateRange();
    }

    private void validateRange() {
        if (bonusBall < Lotto.LOTTO_BALL_MIN || bonusBall > Lotto.LOTTO_BALL_MAX) {
            throw new IllegalArgumentException(Lotto.MSG_ERR_OUT_OF_RANGE);
        }
    }

    public int ball() {
        return this.bonusBall;
    }
}
