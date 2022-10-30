package ui.common;

import domain.lottery.LotteryWinningService;
import domain.ticket.TicketCountService;
import domain.ticket.TicketNumberService;

public interface Result {
    void printAll();

    void printTicketNumbers(TicketCountService ticketCountService, TicketNumberService ticketNumberService);

    void printLotteryResult(LotteryWinningService lotteryWinningService, TicketNumberService ticketNumberService);
}
