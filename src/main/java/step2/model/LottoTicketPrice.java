package step2.model;

public enum LottoTicketPrice {

    PRICE_1000(1_000);

    private final Money ticketPrice;

    LottoTicketPrice(int ticketPrice) {
        this.ticketPrice = Money.valueOf(ticketPrice);
    }

    public LottoCount calculatePurchaseCount(MoneyAmount moneyAmount) {
        int purchaseCount = moneyAmount.getRemainAmount().divideBy(ticketPrice);
        return LottoCount.valueOf(purchaseCount);
    }

    public Money calculatePurchaseAmount(LottoCount lottoCount) {
        return ticketPrice.multiply(lottoCount.getValue());
    }
}
