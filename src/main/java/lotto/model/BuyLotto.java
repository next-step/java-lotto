package lotto.model;

public class BuyLotto {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final int purchaseCount;

    public BuyLotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseAmount / LOTTO_PRICE;
    }
    public int purchaseAmount(){
        return this.purchaseAmount;
    }
    public int purchaseCount(){
        return this.purchaseCount;
    }

}
