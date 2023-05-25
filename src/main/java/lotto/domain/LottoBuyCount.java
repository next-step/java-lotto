package lotto.domain;

public class LottoBuyCount {
    private final int lottoBuyCount;

    LottoBuyCount(int buyPrice, int lottoPrice) {
        this.lottoBuyCount = buyPrice / lottoPrice;
    }

    public boolean isEqualTo(int otherLottoCount) {
        return this.lottoBuyCount == otherLottoCount;
    }
}
