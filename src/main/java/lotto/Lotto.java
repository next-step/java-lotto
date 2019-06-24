package lotto;

public class Lotto {
    static private int PRICE_LOTTO_TICKET = 1000;
    private int ownTickets;

    public Lotto(int input_price) {
        this.ownTickets = input_price / PRICE_LOTTO_TICKET;
    }

    public int getNumOfTicket() {
        return ownTickets;
    }
}
