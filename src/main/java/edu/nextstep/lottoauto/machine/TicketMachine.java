package edu.nextstep.lottoauto.machine;

import edu.nextstep.lottoauto.domain.Ticket;
import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.ticketmaker.TicketMaker;
import edu.nextstep.lottoauto.repository.TicketRepository;

import java.util.List;

public class TicketMachine {

    private final TicketRepository ticketRepository = new TicketRepository();

    public void createAndSaveTickets(int numberOfTickets, TicketMaker ticketMaker) {
    }

    public WinningResultForm confirmWinningResult(String winningNumbersString) {
        return null;
    }

    public List<Ticket> findTickets() {
        return null;
    }
}
