package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.domain.ticketmaker.CustomNumbersMaker;
import edu.nextstep.lottoauto.view.form.WinningResultForm;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningCheckMachine {

    public static WinningResultForm confirmWinningResult(List<Ticket> tickets, String winningNumbersString) {
        Ticket winningTicket = Ticket.madeBy(new CustomNumbersMaker(winningNumbersString));

        Map<Prize, Integer> winningResult = makeWinningResult(winningTicket, tickets);

        double rateOfReturn = ((double) calculateTotalPrize(winningResult) / calculatePayment(tickets));

        return new WinningResultForm(winningResult, rateOfReturn);
    }

    private static Map<Prize, Integer> makeWinningResult(Ticket winningTicket, List<Ticket> tickets) {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        for (Ticket ticket : tickets) {
            int countOfMatching = ticket.countMatchingNumbers(winningTicket);
            Prize prize = Prize.of(countOfMatching);
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
