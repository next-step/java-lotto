package lotto.domain;

public class Ticket {

    private static final String TICKET_ERROR_MESSAGE = "최소 구매 금액은 1,000원입니다.";
    private static final int TICKET_PRICE = 1000;

    private final int buyTotalCount;
    private int buyManualCount;
    private int buyAutoCount;

    public Ticket(final int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException(TICKET_ERROR_MESSAGE);
        }
        this.buyTotalCount = money / TICKET_PRICE;
    }

    public void detailCount(int manual, int auto) {
        this.buyManualCount = manual;
        this.buyAutoCount = auto;
    }

    public int getBuyManualCount() {
        return this.buyManualCount;
    }

    public int getBuyAutoCount() {
        return this.buyAutoCount;
    }

    public int getBuyCash() {
        return this.buyTotalCount * TICKET_PRICE;
    }

    public int getBuyTotalCount() {
        return this.buyTotalCount;
    }
}
