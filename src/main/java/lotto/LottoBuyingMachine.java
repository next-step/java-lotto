package lotto;

public class LottoBuyingMachine {
    private static final int TICKET_PRICE = 1000;
    public int purchaseTicket(String purchaseAmount) {
        return purchaseAmount(purchaseAmount) /TICKET_PRICE;
    }

    private int purchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}
