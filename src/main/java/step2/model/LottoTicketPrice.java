package step2.model;

public enum LottoTicketPrice {

    PRICE_1000(1_000);

    private final Money ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = Money.valueOf(ticketPrice);
    }

    public int getAvailablePurchase(MoneyAmount moneyAmount) {
        return moneyAmount.getRemainAmount().divideBy(ticketPrice);
    }

    public Money calculatePurchaseAmount(int ticketCount) {
        return ticketPrice.multiply(ticketCount);
    }
}
