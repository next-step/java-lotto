package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.ticketmaker.CustomNumbersMaker;
import edu.nextstep.lottobonusnumber.view.form.WinningResultForm;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningCheckMachine {

    public static WinningResultForm confirmWinningResult(List<Ticket> tickets, WinningTicket winningTicket) {
        Map<Prize, Integer> winningResult = makeWinningResult(winningTicket, tickets);

        double rateOfReturn = ((double) calculateTotalPrize(winningResult) / calculatePayment(tickets));

        return new WinningResultForm(winningResult, rateOfReturn);
    }

    private static Map<Prize, Integer> makeWinningResult(WinningTicket winningTicket, List<Ticket> tickets) {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        for (Ticket ticket : tickets) {
            int countOfMatching = ticket.countMatchingNumbers(winningTicket.getWinningTicket());
            boolean hasBonusNumber = ticket.contains(winningTicket.getBonusNumber());
            Prize prize = Prize.of(countOfMatching, hasBonusNumber);
            winningResult.put(prize, (winningResult.getOrDefault(prize,0)+1));
        }

        return winningResult;
    }

    private static int calculateTotalPrize(Map<Prize, Integer> winningResult) {
        return Arrays.stream(Prize.values())
                .mapToInt((prize) -> (prize.getWinningPrize() * winningResult.getOrDefault(prize,0)))
                .sum();
    }

    private static int calculatePayment(List<Ticket> tickets) {
        return tickets.size() * TicketMachine.TICKET_PRICE;
    }
}
