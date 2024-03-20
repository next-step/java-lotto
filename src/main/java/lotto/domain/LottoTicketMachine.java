package lotto.domain;

public class LottoTicketMachine {

    private static final int AMOUNT_PER_TICKET = 1000;

    public static LottoTickets issue(int amount) {
        int countOfTickets = amount / AMOUNT_PER_TICKET;
        return LottoTickets.auto(countOfTickets);
    }

}
