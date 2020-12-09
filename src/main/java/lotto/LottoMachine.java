package lotto;

public interface LottoMachine {

    LottoTickets automatic(long amount);

    LottoTicket manual(String numbers);
}
