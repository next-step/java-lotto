package step2.utils;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoMoney;

    public BuyLotto(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public int buy() {
        return this.lottoMoney / LOTTO_PRICE;
    }
}
