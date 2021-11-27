package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(int lotteryCount, List<Set<Integer>> manualNumber) {
        this(IssueLotteryTicket(lotteryCount, manualNumber));
    }

    private LotteryTickets(List<LotteryTicket> lotteryTicket) {
        this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
    }

    private static List<LotteryTicket> IssueLotteryTicket(int lotteryCount, List<Set<Integer>> manualNumber) {
        List<LotteryTicket> lotteryTicket = new ArrayList<>();
        int manualNumberSize = manualNumber.size();
        for (int i = 0; i < manualNumberSize; i++) {
            lotteryTicket.add(new LotteryTicket(LotteryNumbers.validManualNumber(manualNumber.get(i))));
        }
        int automaticCount = lotteryCount - manualNumberSize;
        for (int i = 0; i < automaticCount; i++) {
            lotteryTicket.add(new LotteryTicket(LotteryNumbers.bringNumber()));
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
