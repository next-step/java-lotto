package lottery.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LotteryTicketsGroup {

    private static final int MINIMUM_WINNER_NUMBER_COUNTS = 3;
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTicketsGroup(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<List<Integer>> getLotteryTicketsNumbers() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getLotteryNumbers)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> findWinnerTicketsMap(LotteryTicket lastWinnerTicket) {
        Map<Integer, Integer> winnerTicketsMap = new HashMap<>();
        int lotteryTicketCounts = lotteryTickets.size();
        for (int i = 0; i < lotteryTicketCounts; i++) {
            LotteryTicket targetLotteryTicket = lotteryTickets.get(i);
            int winnerNumberCounts = getWinnerNumberCounts(targetLotteryTicket, lastWinnerTicket);
            updateWinnerTicketsMap(winnerTicketsMap, winnerNumberCounts);
        }
        return winnerTicketsMap;
    }

    private int getWinnerNumberCounts(LotteryTicket targetLotteryTicket, LotteryTicket lastWinnerTicket) {
        return (int)targetLotteryTicket.getLotteryNumbers().stream()
                .filter(target -> lastWinnerTicket.getLotteryNumbers().stream().anyMatch(Predicate.isEqual(target)))
                .count();
    }

    private void updateWinnerTicketsMap(Map<Integer, Integer> winnerTicketsMap, int winnerNumberCounts) {
        if (winnerNumberCounts < MINIMUM_WINNER_NUMBER_COUNTS) {
            return;
        }
        int lotteryRankCounts = winnerTicketsMap.getOrDefault(winnerNumberCounts, 0) + 1;
        winnerTicketsMap.put(winnerNumberCounts, lotteryRankCounts);
    }
}
