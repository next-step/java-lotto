package lotto.domain;

public class Ticket {

    private static final String ERROR_CANNOT_BUY = "[ERROR] 최소 구매 금액은 1,000원입니다.";
    private static final String ERROR_WRONG_UNIT = "[ERROR] 로또 구매는 1,000원 단위로 가능합니다.";
    private static final int TICKET_PRICE = 1000;

    private final int buyCount;
    private final int cash;

    public Ticket(int cash) {
        this.cash = cash;
        checkMoney();
        this.buyCount = cash / TICKET_PRICE;
    }

    public void checkMoney() {
        if (cash < TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_CANNOT_BUY);
        }

        if (cash % TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ERROR_WRONG_UNIT);
        }
    }

    public int getBuyCash() {
        return this.cash;
    }

    public int getBuyCount() {
        return this.buyCount;
    }
}
