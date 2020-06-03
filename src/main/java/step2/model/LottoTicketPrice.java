package step2.model;

public enum LottoTicketPrice implements Priceable {

    PRICE_1000(1_000);

    private final Money ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = Money.valueOf(ticketPrice);
    }

    @Override
    public Money getPrice() {
        return this.ticketPrice;
    }
}
