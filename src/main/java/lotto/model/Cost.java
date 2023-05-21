package lotto.model;

public class Cost {
    public static final int ONE_LOTTO_TICKET_PRICE = 1_000;
    private final Money money;

    public Cost(Money money) {
        this.money = money;
    }

    public long getMoney() {
        return this.money.amount();
    }

    public int getLottoTicketCount() {
        long count = this.money.amount() / this.ONE_LOTTO_TICKET_PRICE;
        if (count <= 0) {
            System.out.println("해당 금액으로 티켓을 살 수 없습니다.");
        }

        return (int) count;
    }

}
