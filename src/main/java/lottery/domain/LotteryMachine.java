package lottery.domain;

public class LotteryMachine {

    private static final long LOTTERY_TICKET_PRICE = 1000;
    private final int lotteryTicketCounts;

    public LotteryMachine(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.lotteryTicketCounts = (int)(purchasePrice.getPurchasePrice() / LOTTERY_TICKET_PRICE);
    }

    private void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPurchasePrice() < LOTTERY_TICKET_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
    }

    public long getLotteryTicketCounts() {
        return lotteryTicketCounts;
    }
}
