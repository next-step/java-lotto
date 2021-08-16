package edu.nextstep.lottoauto.machine;

import edu.nextstep.lottoauto.domain.Prize;
import edu.nextstep.lottoauto.domain.Ticket;
import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.ticketmaker.TicketMaker;
import edu.nextstep.lottoauto.repository.TicketRepository;

import java.util.*;

public class TicketMachine {

    private static final int A_UNIT_PRICE = 1_000;

    private final TicketRepository ticketRepository = new TicketRepository();

    public void createAndSaveTickets(int numberOfTickets, TicketMaker ticketMaker) {
        for (int i = 0; i < numberOfTickets; i++) {
            Ticket ticket = ticketMaker.create();
            ticketRepository.save(ticket);
        }
    }

    public List<Ticket> findTickets() {
        return ticketRepository.findAll();
    }

    public WinningResultForm confirmWinningResult(List<Integer> winningNumbers) {
        List<Ticket> tickets = ticketRepository.findAll();

        Map<Prize, Integer> winningResult = makeWinningResult(winningNumbers, tickets);

        double rateOfReturn = ((double)calculateTotalPrize(winningResult) / calculatePayment(tickets));

        return new WinningResultForm(winningResult, rateOfReturn);
    }

    private Map<Prize, Integer> makeWinningResult(List<Integer> winningNumbers, List<Ticket> tickets) {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        for (Ticket ticket : tickets) {
            int countOfMatching = ticket.countMatchingNumbers(winningNumbers);
            Prize prize = Prize.of(countOfMatching);
            winningResult.put(prize, (winningResult.getOrDefault(prize,0)+1));
        }

        return winningResult;
    }

    private long calculateTotalPrize(Map<Prize, Integer> winningResult) {
        long totalPrize = 0;
        for(Prize prize : Prize.values()) {
            totalPrize += ((long)prize.getWinningPrize() * winningResult.getOrDefault(prize,0));
        }
        return totalPrize;
    }

    private int calculatePayment(List<Ticket> tickets) {
        return tickets.size() * A_UNIT_PRICE;
    }
}
