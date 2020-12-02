package lotto;

//@FunctionalInterface
public interface LottoTicketCreatable {

    LottoTicket createTicket();
    LottoTickets createTickets(int purchaseNumber);
}
