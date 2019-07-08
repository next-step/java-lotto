package domain;

public final class LottoMoney {
    public static final int TICKET_PRICE = 1000;
    private final int money;

    public LottoMoney(int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int getTryNo() {
        return money / TICKET_PRICE;
    }
}
