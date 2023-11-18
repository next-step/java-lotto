package autolotto.domain;

public class Ticket {
    private static final int LOTTO_PRICE = 1000;

    private int buyAmt;

    public Ticket(int buyAmt) {
        this.buyAmt = buyAmt;
    }

    public int toTicketCount() {
        return buyAmt / LOTTO_PRICE;
    }
}
