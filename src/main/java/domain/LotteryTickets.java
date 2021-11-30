package domain;

import java.util.*;

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
        for (int i = 0; i < lotteryCount; i++) {
            lotteryTicket.add(lottery(i, manualNumber));
        }
        return lotteryTicket;
    }

    private static LotteryTicket lottery(int index, List<Set<Integer>> manual) {
        if (index < manual.size()) {
            return LotteryTicket.from(numbers(manual.get(index)));
        }
        return LotteryTicket.from(numbers(LotteryNumbers.auto()));
    }

    private static Set<LotteryNumber> numbers(Set<Integer> numbers) {
        return LotteryTicket.validLotteryNumber(numbers);
    }

    public LotteryTicket findLotteryTicket(int index) {
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
