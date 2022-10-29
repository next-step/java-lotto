package ui;

import domain.LotteryWinningService;
import domain.TicketCountService;
import domain.TicketNumberService;

public interface Result {
    void printAll();

    void printTicketNumbers(TicketCountService ticketCountService, TicketNumberService ticketNumberService);

    void printLotteryResult(LotteryWinningService lotteryWinningService, TicketNumberService ticketNumberService);
}
