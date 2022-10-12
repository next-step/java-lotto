package lotto.domain;

public class Payment {

    private final static int LOTTO_TICKET_PRICE = 1000;
    private final static int LOTTO_TICKET_BUY_MAX_PRICE = 100000;

    private final int amount;

    public Payment(int amount) {
        if (amount < LOTTO_TICKET_PRICE || amount > LOTTO_TICKET_BUY_MAX_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 올바르지 않습니다. (최소 금액:" + LOTTO_TICKET_PRICE + "원, 최대 금액:" + LOTTO_TICKET_BUY_MAX_PRICE + ")");
        }
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public int count() {
        return amount / LOTTO_TICKET_PRICE;
    }
}
