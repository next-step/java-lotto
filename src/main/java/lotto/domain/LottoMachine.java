package lotto.domain;

import java.util.List;

public interface LottoMachine {

    List<Ticket> buyTicket(int ticketCounts);
}
