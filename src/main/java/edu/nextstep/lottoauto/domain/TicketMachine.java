package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.domain.ticketmaker.CustomNumbersMaker;
import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.view.form.WinningResultForm;
import edu.nextstep.lottoauto.domain.ticketmaker.NumbersMaker;

import java.util.*;

public class TicketMachine {

    private static final int TICKET_PRICE = 1_000;

    private final TicketRepository ticketRepository = new TicketRepository();

    public void createAndSaveTickets(int payment, NumbersMaker numbersMaker) {
        validateUnderAUnitPrice(payment);
        validateDivideUnitPrice(payment);

        int numberOfTickets = calculateNumberOfTicketsFrom(payment);
        for (int i = 0; i < numberOfTickets; i++) {
            Ticket ticket = Ticket.madeBy(numbersMaker);
            ticketRepository.save(ticket);
        }
    }

    public int calculateNumberOfTicketsFrom(int payment) {
        return payment / TICKET_PRICE;
    }


    public List<Ticket> findTickets() {
        return ticketRepository.findAll();
    }

    public WinningResultForm confirmWinningResult(Ticket winningTicket) {
        List<Ticket> tickets = ticketRepository.findAll();

        Map<Prize, Integer> winningResult = makeWinningResult(winningTicket, tickets);

        double rateOfReturn = ((double)calculateTotalPrize(winningResult) / calculatePayment(tickets));

        return new WinningResultForm(winningResult, rateOfReturn);
    }

    private Map<Prize, Integer> makeWinningResult(Ticket winningTicket, List<Ticket> tickets) {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        for (Ticket ticket : tickets) {
            int countOfMatching = ticket.countMatchingNumbers(winningTicket);
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
        return tickets.size() * TICKET_PRICE;
    }

    public WinningResultForm confirmWinningResult(String winningNumbersString) {
        Ticket winningTicket = createCustomTicket(winningNumbersString);
        return confirmWinningResult(winningTicket);
    }

    public Ticket createCustomTicket(String winningNumbersString) {
        return Ticket.madeBy(new CustomNumbersMaker(winningNumbersString));
    }

    private void validateUnderAUnitPrice(int payment) {
        if (payment < TICKET_PRICE) {
            throw new PaymentIllegalArgumentException("최소 입력 가능 금액 미달. 최소 입력 금액 : " + TICKET_PRICE + " 원");
        }
    }

    private void validateDivideUnitPrice(int payment) {
        if ((payment % TICKET_PRICE) != 0) {
            throw new PaymentIllegalArgumentException("개 당 금액 " + TICKET_PRICE + " 원으로 해당 단위로 입력 필요.");
        }
    }
}
