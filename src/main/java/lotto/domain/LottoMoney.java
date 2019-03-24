package lotto.domain;

public class LottoMoney {
    public static final long LOTTO_UNIT_PRICE = 1_000;
    private final long money;

    public LottoMoney(long money) {
        if (money < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(LOTTO_UNIT_PRICE + " OR MORE");
        }

        this.money = money;
    }

    public LottoMoney(String money) {
        this.money = Long.parseLong(money);
        new LottoMoney(this.money);
    }

    public int countOfLotto() {
        return (int) (this.money / LOTTO_UNIT_PRICE);
    }

    public double calculateEarningsRate(final WinningResults winningResults) {
        return winningResults.calculateEarningsRate(money);
    }
}
