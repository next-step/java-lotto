package lotto.domain;

public class Profit {

    private static final int ZERO = 0;

    private final double profitRate;

    public Profit(long profit, long principal) {
        validateNotZero(principal);
        this.profitRate = (double) profit / principal;
    }

    private void validateNotZero(long money) {
        if (money == ZERO) {
            throw new IllegalArgumentException("원금은 0보다 커야 합니다.");
        }
    }

    public double getProfitRate() {
        return profitRate;
    }
}
