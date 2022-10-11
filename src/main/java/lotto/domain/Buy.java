package lotto.domain;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Buy {

    private final int price;
    private final int purchaseAmount;
    private final int count;

    public Buy(int price, int purchaseAmount) {
        this.price = price;
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
