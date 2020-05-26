package lottery.domain;

import java.util.ArrayList;
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

    public List<LotteryTicket> findWinnerTicketsGroup(LotteryTicket lastWinnerTicket) {
        List<LotteryTicket> winnerTicketsGroup = new ArrayList<>();
        int lotteryTicketCounts = lotteryTickets.size();
        for (int i = 0; i < lotteryTicketCounts; i++) {
            LotteryTicket targetLotteryTicket = lotteryTickets.get(i);
            int winnerNumberCounts = getWinnerNumberCounts(targetLotteryTicket, lastWinnerTicket);
            updateWinnerTicketsGroup(winnerTicketsGroup, targetLotteryTicket, winnerNumberCounts);
        }
        return winnerTicketsGroup;
    }

    private int getWinnerNumberCounts(LotteryTicket targetLotteryTicket, LotteryTicket lastWinnerTicket) {
        return (int)targetLotteryTicket.getLotteryNumbers().stream()
                .filter(target -> lastWinnerTicket.getLotteryNumbers().stream().anyMatch(Predicate.isEqual(target)))
                .count();
    }

    private void updateWinnerTicketsGroup(List<LotteryTicket> winnerTicketsGroup,
                                          LotteryTicket targetLotteryTicket,
                                          int winnerNumberCounts) {
        if (winnerNumberCounts >= MINIMUM_WINNER_NUMBER_COUNTS)
            winnerTicketsGroup.add(targetLotteryTicket);
    }
}
