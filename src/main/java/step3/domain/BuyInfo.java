package step3.domain;

public class BuyInfo {
    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getTotalCount() {
        return totalCount;
    }

    private int totalCount;

    public BuyInfo(int totalPrice, int oneGamePrice) {
        if (totalPrice < oneGamePrice){
            throw new IllegalArgumentException(oneGamePrice + "보다 큰 금액 입력");
        }
        this.totalPrice = totalPrice;
        this.totalCount = totalPrice/oneGamePrice;
    }
}
