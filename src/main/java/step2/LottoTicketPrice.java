package step2;

public enum LottoTicketPrice {
    PRICE_1000(1_000);

    private final int ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getPrice() {
        return this.ticketPrice;
    }
}
