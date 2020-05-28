package step2.model;

public enum LottoTicketPrice {
    PRICE_1000(1_000);

    private final int ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static LottoTicketPrice getDefault() {
        return LottoTicketPrice.PRICE_1000;
    }

    public int getPrice() {
        return this.ticketPrice;
    }
}
