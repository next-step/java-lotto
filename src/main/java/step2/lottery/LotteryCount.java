package step2.lottery;

public class LotteryCount {
    private final int autoLottoCount;
    private final int manualLottoCount;
    private static final int LOTTO_PRICE = 1000;

    public LotteryCount(int purchaseAmount) {
        validate(purchaseAmount);
        this.autoLottoCount = count(purchaseAmount);
        this.manualLottoCount = 0;
    }

    public LotteryCount(int purchaseAmount, int manualCount) {
        int totalAmount = purchaseAmount - (manualCount * LOTTO_PRICE);
        validate(totalAmount);
        this.autoLottoCount = count(totalAmount);
        this.manualLottoCount = manualCount;
    }

    private int count(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("음수 값이 입력되었습니다. 값 : " + purchaseAmount);
        }
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한 장의 가격보다 작은 금액입니다. 값 : " + purchaseAmount);
        }
    }
    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
