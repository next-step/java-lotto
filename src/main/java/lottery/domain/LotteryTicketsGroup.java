package lottery.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LotteryTicketsGroup {

    private static final int MINIMUM_MATCH_NUMBER_COUNTS = 3;
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTicketsGroup(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<List<Integer>> getLotteryTicketsNumbers() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getLotteryNumbers)
                .collect(Collectors.toList());
    }

    public Map<LotteryRank, Integer> findWinnerTicketCountsByRankMap(LotteryTicket lastWinnerTicket) {
        Map<LotteryRank, Integer> winnerTicketCountsByRankMap = new HashMap<>();
        int lotteryTicketCounts = lotteryTickets.size();
        for (int i = 0; i < lotteryTicketCounts; i++) {
            LotteryTicket targetLotteryTicket = lotteryTickets.get(i);
            int matchNumberCounts = getMatchNumberCounts(targetLotteryTicket, lastWinnerTicket);
            updateWinnerTicketsCountsByRankMap(winnerTicketCountsByRankMap, matchNumberCounts);
        }
        return winnerTicketCountsByRankMap;
    }

    private int getMatchNumberCounts(LotteryTicket targetLotteryTicket, LotteryTicket lastWinnerTicket) {
        return (int)targetLotteryTicket.getLotteryNumbers().stream()
                .filter(target -> lastWinnerTicket.getLotteryNumbers().stream().anyMatch(Predicate.isEqual(target)))
                .count();
    }

    private void updateWinnerTicketsCountsByRankMap(Map<LotteryRank, Integer> winnerTicketCountsByRankMap,
                                                    int matchNumberCounts) {
        if (matchNumberCounts < MINIMUM_MATCH_NUMBER_COUNTS) {
            return;
        }
        LotteryRank lotteryRank = LotteryRank.valueOf(matchNumberCounts);
        int winnerTicketCounts = winnerTicketCountsByRankMap.getOrDefault(lotteryRank, 0) + 1;
        winnerTicketCountsByRankMap.put(lotteryRank, winnerTicketCounts);
    }
}
