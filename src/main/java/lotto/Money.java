package lotto;

public class Money {
    private static final int PRICE_PER_LOTTO = 1_000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int calcLottoCount() {
        return money / PRICE_PER_LOTTO;
    }

    public Money autoLottoMoney(int manualLottoCount) {
        return new Money(money - (PRICE_PER_LOTTO * manualLottoCount));
    }

    double profitRate(Money totalPrize) {
        return Double.parseDouble(String.format("%.2f", (totalPrize.money / (double) money)));
    }

    public Money sum(Money money) {
        return new Money(this.money + money.money);
    }
}
