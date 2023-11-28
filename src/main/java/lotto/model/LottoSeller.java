package lotto.model;

public class LottoSeller {
    private static final int TICKET_PRICE = 1000;

    public static int calculateTicketCount(int money) {
        return money/TICKET_PRICE;
    }

    public static int price(int count) {
        return count * TICKET_PRICE;
    }

    public static Lottos issueLotto(int money) {
        int ticketCount = calculateTicketCount(money);
        return Lottos.generate(ticketCount);
    }
}
