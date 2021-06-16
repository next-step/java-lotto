package kr.aterilio.nextstep.techcamp.m1.lotto;

public class BonusBall {

    private final LottoBall bonusBall;

    public BonusBall(int bonusBall) {
        this.bonusBall = LottoBall.of(bonusBall);
    }

    public int ball() {
        return this.bonusBall.number();
    }
}
