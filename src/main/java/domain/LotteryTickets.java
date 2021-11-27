package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(int lotteryCount) {
        this(IssueLotteryTicket(lotteryCount));
    }

    private LotteryTickets(List<LotteryTicket> lotteryTicket) {
        this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
    }

    private static List<LotteryTicket> IssueLotteryTicket(int lotteryCount) {
        LotteryNumbers lotteryNumbers = new LotteryNumbers();

        List<LotteryTicket> lotteryTicket = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            lotteryTicket.add(new LotteryTicket(lotteryNumbers.bringNumber()));
        }

        return lotteryTicket;
    }

    public LotteryTicket lotteryTicket(int index) {
        return lotteryTickets.get(index);
    }

    public int matchLottery(int index, WinningLottery lastWeekLottery) {
        return lotteryTickets.get(index).matchCount(lastWeekLottery);
    }

    public int matchBonusBoll(int index, int rank, WinningLottery winningLottery) {
        return lotteryTickets.get(index).matchBonusBall(rank, winningLottery);
    }

    public int size() {
        return lotteryTickets.size();
    }
}
