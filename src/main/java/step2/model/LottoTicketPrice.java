package step2.model;

public enum LottoTicketPrice implements Priceable {

    PRICE_1000(1_000),
    PRICE_2000(2_000);

    private final int ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static LottoTicketPrice getDefault() {
        return LottoTicketPrice.PRICE_1000;
    }

    @Override
    public int getPrice() {
        return this.ticketPrice;
    }
}
