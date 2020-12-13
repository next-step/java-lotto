package lotto;

public class Lotto {
    private static final int ONE_LOTTO_PRICE = 1000;
    private int purchaseAmount;

    public Lotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    protected int purchaseQuantity() {
        if (purchaseAmount < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해야합니다.");
        }
        return purchaseAmount / ONE_LOTTO_PRICE;
    }

    public double rewardRatio(long totalReward) {
        return Math.floor((totalReward / (double)purchaseAmount)*100)/100.0;
    }
}
