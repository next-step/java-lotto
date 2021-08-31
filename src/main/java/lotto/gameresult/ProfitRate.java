package lotto.gameresult;

import lotto.game.Payments;

public class ProfitRate {
    private final double prizeMoney;
    private final Payments payments;

    public ProfitRate(int prizeMoney, int payments) {
        this.prizeMoney = prizeMoney;
        this.payments = new Payments(payments);
    }

    public ProfitRate(int prizeMoney, Payments payments) {
        this.prizeMoney = prizeMoney;
        this.payments = payments;
    }

    public double value() {
        return prizeMoney / payments.value();
    }

    public boolean isLessthan(double number) {
        return this.value() < number;
    }

    public boolean isGreaterthan(double number) {
        return this.value() > number;
    }
}
