package lottery.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LotteryTicketsGroup {

    private static final int MINIMUM_MATCH_NUMBER_COUNTS = 3;
    private static final int DEFAULT_WINNER_TICKET_COUNTS = 0;
    private static final int COUNT_ONE = 1;
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
        lotteryTickets.forEach(targetLotteryTicket ->
                checkLotteryRank(targetLotteryTicket, lastWinnerTicket, winnerTicketCountsByRankMap));
        return winnerTicketCountsByRankMap;
    }

    private void checkLotteryRank(LotteryTicket targetLotteryTicket,
                                  LotteryTicket lastWinnerTicket,
                                  Map<LotteryRank, Integer> winnerTicketCountsByRankMap) {
        int matchNumberCounts = getMatchNumberCounts(targetLotteryTicket, lastWinnerTicket);
        updateWinnerTicketCountsByRankMap(winnerTicketCountsByRankMap, matchNumberCounts);
    }

    private int getMatchNumberCounts(LotteryTicket targetLotteryTicket, LotteryTicket lastWinnerTicket) {
        return (int)targetLotteryTicket.getLotteryNumbers().stream()
                .filter(target -> lastWinnerTicket.getLotteryNumbers().stream().anyMatch(Predicate.isEqual(target)))
                .count();
    }

    private void updateWinnerTicketCountsByRankMap(Map<LotteryRank, Integer> winnerTicketCountsByRankMap,
                                                    int matchNumberCounts) {
        if (matchNumberCounts < MINIMUM_MATCH_NUMBER_COUNTS) {
            return;
        }
        LotteryRank lotteryRank = LotteryRank.valueOf(matchNumberCounts);
        int winnerTicketCounts = winnerTicketCountsByRankMap.getOrDefault(lotteryRank, DEFAULT_WINNER_TICKET_COUNTS)
                + COUNT_ONE;
        winnerTicketCountsByRankMap.put(lotteryRank, winnerTicketCounts);
    }
}
