package lotto.controller;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
    public static List<Ticket> buyTickets(int investMoney) {
        Money money = Money.valueOf(investMoney);
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < money.getNumberOfTicketForPurchase(); i++) {
            Ticket ticket = Ticket.generateRandomTicket();
            tickets.add(ticket);
        }

        return tickets;
    }

    public static int getPurchasePrice(int investMoney) {
        Money money = Money.valueOf(investMoney);

        int numberOfTicket = money.getNumberOfTicketForPurchase();
        Money purchasePrice = Money.valueOf(Money.TICKET_PRICE).multiple(numberOfTicket);

        return purchasePrice.toInteger();
    }

    public static WinningTicket drawWinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        Ticket ticket = Ticket.generateTicket(winningNumbers.stream()
                .map(Ball::valueOf)
                .collect(Collectors.toSet()));
        Ball bonus = Ball.valueOf(bonusNumber);

        return new WinningTicket(ticket, bonus);
    }

    public static Statistics simulate(List<Ticket> tickets, WinningTicket winningTicket) {
        Statistics statistics = new Statistics();
        for (Ticket ticket : tickets) {
            Rank rank = winningTicket.getRank(ticket);
            statistics.put(rank);
        }

        return statistics;
    }
}
