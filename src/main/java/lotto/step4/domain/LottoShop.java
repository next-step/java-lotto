package lotto.step4.domain;

public class LottoShop {
    private final int manualCount;

    public LottoShop(int manualCount) {
        this.manualCount = manualCount;
    }

    public Lotteries receiveMoney(int money) {
        return new Lotteries(money / Money.LOTTO_PRICE);
    }
}
