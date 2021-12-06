package lottery.controller;

import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.PurchasePrice;
import lottery.dto.LotteryResultDto;

public class LotteryMachine {

    private final LotteryTickets lotteryTickets;

    private LotteryMachine(final LotteryTickets lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public static LotteryMachine create(final PurchasePrice purchasePrice) {
        final LotteryTickets tickets = purchasePrice.boughtTickets();
        return new LotteryMachine(tickets);
    }

    public LotteryResultDto result(final LotteryTicket winnerTicket) {
        return lotteryTickets.lotteryResultDto(winnerTicket);
    }

    public LotteryTickets tickets() {
        return lotteryTickets;
    }
}
