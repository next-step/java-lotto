package lottery.domain;

public class RevenueRate {

    private final int FLOOR_DIGITS = 100;

    public final double rate;

    public RevenueRate(Money revenue, Money myMoney) {
        if (myMoney.amount == 0) {
            throw new ArithmeticException();
        }

        this.rate = floor(cal(revenue, myMoney), FLOOR_DIGITS);
    }

    private double floor(double value, int digits) {
        return Math.floor(value * digits) / digits;
    }

    private double cal(Money revenue, Money myMoney) {
        return (double) revenue.amount / myMoney.amount;
    }
}
