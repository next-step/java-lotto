package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(int lotteryCount, List<Set<Integer>> manualNumber) {
        this(IssueLotteryTicket(lotteryCount, manualNumber));
    }

    private LotteryTickets(List<LotteryTicket> lotteryTicket) {
        this.lotteryTickets = Collections.unmodifiableList(lotteryTicket);
    }

    private static List<LotteryTicket> IssueLotteryTicket(int lotteryCount, List<Set<Integer>> manualNumber) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        lotteryTickets.addAll(manual(manualNumber));
        lotteryTickets.addAll(auto(lotteryCount - manualNumber.size()));
        return lotteryTickets;
    }

    private static List<LotteryTicket> manual(List<Set<Integer>> manualNumber) {
        return IntStream.range(0, manualNumber.size())
                .mapToObj(i -> new LotteryTicket(numbers(manualNumber.get(i))))
                .collect(Collectors.toList());
    }

    private static List<LotteryTicket> auto(int loopNumber) {
        return IntStream.range(0, loopNumber)
                .mapToObj(i -> new LotteryTicket(numbers(LotteryNumbers.auto())))
                .collect(Collectors.toList());
    }

    private static Set<LotteryNumber> numbers(Set<Integer> numbers) {
        return LotteryTicket.lotteryTicket(numbers);
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
