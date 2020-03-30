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
        if (totalPrice <= 0 ){
            throw new IllegalArgumentException("로또 구매가격은 0보다 커야합니다.");
        }
        if (totalPrice < oneGamePrice){
            throw new IllegalArgumentException("구매가격은 로또 장당가격인 " + oneGamePrice + "보다 큰 금액 입력");
        }
        this.totalPrice = totalPrice;
        this.totalCount = totalPrice/oneGamePrice;
    }
}
