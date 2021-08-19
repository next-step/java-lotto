package lotto.step4.domain;


public class LottoShop {
    private final LottoCount lottoCount;

    public LottoShop(int lottoCount) {
        this.lottoCount = new LottoCount(lottoCount);
    }

    public int receiveMoney(int money) {
        return lottoCount.createAutoCount(money);
    }
}
