package step2.lottery;

public class LotteryCount {
    private final int lottoCount;
    private static final int LOTTO_PRICE = 1000;

    public LotteryCount(int purchaseAmount) {
        validate(purchaseAmount);
        this.lottoCount = purchaseAmount / LOTTO_PRICE;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("음수 값이 입력되었습니다. 값 : " + purchaseAmount);
        }
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한 장의 가격보다 작은 금액입니다. 값 : " + purchaseAmount);
        }
    }
    public int getLottoCount() {
        return lottoCount;
    }
}
