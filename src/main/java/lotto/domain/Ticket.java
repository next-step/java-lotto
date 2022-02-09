package lotto.domain;

public class Ticket {

    private static final String ERROR_CANNOT_BUY = "[ERROR] 최소 구매 금액은 1,000원입니다.";
    private static final String ERROR_WRONG_UNIT = "[ERROR] 로또 구매는 1,000원 단위로 가능합니다.";
    private static final int TICKET_PRICE = 1000;

    private final int buyCount;
    private final int money;

    public Ticket(int money) {
        this.money = money;
        checkMoney();
        this.buyCount = money / TICKET_PRICE;
    }

    public void checkMoney() {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_CANNOT_BUY);
        }

        if (money % TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ERROR_WRONG_UNIT);
        }
    }

    public int getBuyCash() {
        return this.buyCount * TICKET_PRICE;
    }

    public int getBuyCount() {
        return this.buyCount;
    }
}
