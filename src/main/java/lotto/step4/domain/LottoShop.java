package lotto.step4.domain;

public class LottoShop {
    private final LottoCount lottoCount;

    public LottoShop(int lottoCount) {
        this.lottoCount = new LottoCount(lottoCount);
    }

    public Lotteries receiveMoney(int money) {
        int autoCount = lottoCount.createAutoCount(money);
        return new Lotteries(autoCount);
    }
}
