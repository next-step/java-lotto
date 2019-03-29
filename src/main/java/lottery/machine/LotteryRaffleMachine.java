package lottery.machine;

import lottery.domain.LotteryTicket;
import lottery.domain.LotteryWinningStatistics;
import lottery.domain.WinningTicket;

import java.util.ArrayList;
import java.util.List;

public class LotteryRaffleMachine {

    private final List<LotteryTicket> tickets;

    public LotteryRaffleMachine(List<LotteryTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public LotteryWinningStatistics raffle(WinningTicket winningTicket) {
        return new LotteryWinningStatistics(winningTicket, new ArrayList<>(this.tickets));
    }
}
