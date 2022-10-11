package lotto.domain;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class PurchaseInfo {

    public static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final int count;

    public PurchaseInfo(int price, int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.count = calculateCount(price, purchaseAmount);
    }

    private int calculateCount(int price, int pay) {
        if (pay % price != 0) {
            throw new IllegalArgumentException("잘못된 구매 금액 입니다");
        }
        return pay / price;
    }

    public int getCount() {
        return count;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
