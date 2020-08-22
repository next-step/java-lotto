package step2.utils;

public class BuyLotto {
    public final int lottoMoney;
    public static final int LOTTO_PRICE = 1000;

    public BuyLotto(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public int buy() {
        return this.lottoMoney / LOTTO_PRICE;
    }
}
