package step2.model;

public enum LottoTicketPrice implements Priceable {

    PRICE_1000(1_000);

    private final int ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public int getPrice() {
        return this.ticketPrice;
    }
}
