/*
 * TicketManager.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.strategy.NumberMaker;
import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private static final int PRICE_PER_ONE_TICKET = 1_000;

    private List<Ticket> tickets;
    private WinningNumbers winningNumbers;

    public void createTickets(int payment, NumberMaker numberMaker) {
        validateMinPayment(payment);
        validateBeDivisibleByPrice(payment);

        this.tickets = new ArrayList<>();
        int numberOfTickets = payment / PRICE_PER_ONE_TICKET;
        while (numberOfTickets > 0) {
            tickets.add(Ticket.create(numberMaker));
            numberOfTickets--;
        }
    }

    public void setWinningNumbersFrom(String winningNumbersString) {
        this.winningNumbers = WinningNumbers.from(winningNumbersString);
    }

    public WinningPrizeResult makeWinningPrizeResult() {
        List<Ticket> winningTickets = getWinningTickets();
        int totalPrize = getTotalPrize(winningTickets);
        double rateOfReturn = ((double)totalPrize / ((tickets.size()) * PRICE_PER_ONE_TICKET));
        return WinningPrizeResult.of(winningTickets, rateOfReturn);
    }

    private List<Ticket> getWinningTickets() {
        List<Ticket> winningTickets = new ArrayList<>();

        tickets.forEach(
                (ticket) -> ticket.checkAndUpdateWinningPrize(winningNumbers)
        );

        tickets.stream().
                filter((ticket) -> ticket.getPrize() != null).
                forEach(winningTickets::add);

        return winningTickets;
    }

    private int getTotalPrize(List<Ticket> winningTickets) {
        return winningTickets.stream()
                .mapToInt((ticket) -> ticket.getPrize().getPrize())
                .sum();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    
    private void validateMinPayment(int payment) {
        if(payment < PRICE_PER_ONE_TICKET){
            throw new IllegalArgumentException("최소 금액은 1,000원 입니다. 입력값 : " + payment);
        }
    }

    private void validateBeDivisibleByPrice(int payment) {
        if ((payment % PRICE_PER_ONE_TICKET) != 0) {
            throw new IllegalArgumentException("1,000원 단위 입력이 필요합니다. 입력값 : " + payment);
        }
    }
}
