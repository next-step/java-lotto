package kr.aterilio.nextstep.techcamp.m1.lotto.result;

public class EarningsRate {

    private static final int EMPTY_PAID = 0;
    private static final float NONE_RETURN_RATE = 0.f;

    private final float earningsRate;

    public EarningsRate(int prize, int paid) {
        earningsRate = calculateRateOfReturn(prize, paid);
    }

    private float calculateRateOfReturn(int prize, int paid) {
        if (paid == EMPTY_PAID) {
            return NONE_RETURN_RATE;
        }
        return (float) prize / paid;
    }

    public float value() {
        return earningsRate;
    }
}
