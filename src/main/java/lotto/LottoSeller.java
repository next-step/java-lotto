package lotto;

public class LottoSeller {
    private static int LOTTO_TICKET_PRICE = 1_000;
    private int ticketCount;

    public LottoSeller(int money) {
        validate(money);
        this.ticketCount = money / LOTTO_TICKET_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
