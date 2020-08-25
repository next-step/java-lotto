package step2.utils;

public class BuyLotto {
    private final int lottoMoney;
    private static final int LOTTO_PRICE = 1000;

    public BuyLotto(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public int buy() {
        return this.lottoMoney / LOTTO_PRICE;
    }
}
