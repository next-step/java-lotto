package lotto.domain;

public class LottoBuy {

    private final LottoBuyCount lottoBuyCount;

    LottoBuy(int buyPrice) {
        this.lottoBuyCount = new LottoBuyCount(buyPrice);
    }

    public boolean lottoBuyCountIsEqualTo(int otherLottoCount) {
        return this.lottoBuyCount.isEqualTo(otherLottoCount);
    }
}
