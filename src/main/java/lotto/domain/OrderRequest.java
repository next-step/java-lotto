package lotto.domain;

public class OrderRequest {

    private final int amount;

    public OrderRequest(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static OrderRequest from(Money money) {
        return new OrderRequest(money.divideBy(LottoTicket.PRICE));
    }
}
