package lotto.domain;

public class LottoBuy {

    private static final int LOTTO_PRICE = 1000;

    private final LottoBuyCount lottoBuyCount;

    LottoBuy(int buyPrice) {
        this.lottoBuyCount = new LottoBuyCount(buyPrice, LOTTO_PRICE);
    }

    public boolean lottoCountIsEqualTo(int otherLottoCount) {
        return this.lottoBuyCount.isEqualTo(otherLottoCount);
    }
}
