package lotto;

public class Lotto {
    public int purchaseQuantity(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해야합니다.");
        }
        return price / 1000;
    }
}
