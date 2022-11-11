package ui.common;

import service.LotteryService;

public interface Result {
    void printAll();

    void printTicketNumbers();

    void printLotteryResult(LotteryService lotteryService);
}
