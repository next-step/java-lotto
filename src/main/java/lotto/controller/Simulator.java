package lotto.controller;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
    private static final String MESSAGE_OF_CANNOT_NEGATIVE_COUNT = "수동으로 뽑을 티켓수는 음수일 수 없습니다.";
    private static final String MESSAGE_OF_TICKET_COUNT_IS_OVER = "구매할 수 있는 티켓 수량이 아닙니다.";

    public static List<Ticket> buyTickets(TicketGenerator ticketGenerator, int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = ticketGenerator.generate();
            tickets.add(ticket);
        }

        return tickets;
    }

    public static int getPurchasePrice(int investMoney, int countOfManualTicket) {
        Money money = Money.valueOf(investMoney);

        int numberOfTicket = money.getNumberOfTicketForPurchase();
        Money purchasePrice = Money.valueOf(Money.TICKET_PRICE).multiple(numberOfTicket);

        return purchasePrice.toInteger();
    }

    public static int getCountOfAutomaticTicket(int investMoney, int countOfManualTicket) {
        Money money = Money.valueOf(investMoney);
        int availableCount = money.getNumberOfTicketForPurchase();

        checkCountOfManualTicket(countOfManualTicket);
        checkCountIsAvailable(availableCount, countOfManualTicket);

        return availableCount - countOfManualTicket;
    }

    private static void checkCountOfManualTicket(int countOfManualTicket) {
        if (countOfManualTicket < 0) {
            throw new IllegalArgumentException(MESSAGE_OF_CANNOT_NEGATIVE_COUNT);
        }
    }

    private static void checkCountIsAvailable(int availableCount, int countOfManualTicket) {
        if (availableCount < countOfManualTicket) {
            throw new IllegalArgumentException(MESSAGE_OF_TICKET_COUNT_IS_OVER);
        }
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
