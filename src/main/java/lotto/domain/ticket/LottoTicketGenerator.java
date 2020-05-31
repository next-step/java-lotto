package lotto.domain.ticket;

@FunctionalInterface
public interface LottoTicketGenerator {

    LottoTicket generate();
}
