package lotto.domain;

public class Lotto {

    private static final int TICKET_PRICE = 1000;

    public int calculatePurchaseQuantity(int purchaseAmount) {

        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException("로또를 구매하기 적절한 금액이 아닙니다: " + purchaseAmount);
        }

        return purchaseAmount/TICKET_PRICE;
    }
}
