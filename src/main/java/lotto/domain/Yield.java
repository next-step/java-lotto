package lotto.domain;

public class Yield {
    private double yield;

    public Yield(double yield) {
        if (yield < 0) {
            throw new IllegalArgumentException("수익률은 0보다 작을 수 없습니다.");
        }
        this.yield = yield;
    }

    public double getYield() {
        return yield;
    }
}
