package lotto.domain;

public class LottoBuyCount {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoBuyCount;

    LottoBuyCount(int buyPrice) {
        this.lottoBuyCount = buyPrice / LOTTO_PRICE;
    }

    public boolean isEqualTo(int otherLottoCount) {
        return this.lottoBuyCount == otherLottoCount;
    }
}
