package lotto;

public class Lotto {
    private int purchaseAmount;

    public Lotto() {
    }

    public Lotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    protected int purchaseQuantity(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해야합니다.");
        }
        return purchaseAmount / 1000;
    }

    public double rewardRatio(long totalReward) {
        return Math.floor((totalReward / (double)purchaseAmount)*100)/100.0;
    }
}
