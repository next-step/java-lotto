package step2.domain;

public class Money {
    private static final int TICKET_PRICE = 1000;
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if ((money <= 0) || (money % TICKET_PRICE != 0)) {
            throw new IllegalArgumentException("해당 금액으로는 티켓을 구매할 수 없습니다.");
        }
    }

    public int getTotalLottoTicketCount() {
        return money / TICKET_PRICE;
    }
}
