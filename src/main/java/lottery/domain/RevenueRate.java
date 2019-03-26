package lottery.domain;

public class RevenueRate {

    private final int FLOOR_DIGITS = 100;

    private final double rate;

    public RevenueRate(Money revenue, Money myMoney) {
        if (myMoney == Money.ZERO) {
            throw new ArithmeticException();
        }

        this.rate = floor(cal(revenue, myMoney), FLOOR_DIGITS);
    }

    private double floor(double value, int digits) {
        return Math.floor(value * digits) / digits;
    }

    private double cal(Money revenue, Money myMoney) {
        return (double) revenue.getAmount() / myMoney.getAmount();
    }

    public double getRate() {
        return this.rate;
    }

    public int percentage() {
        return (int) (rate * 100);
    }
}
