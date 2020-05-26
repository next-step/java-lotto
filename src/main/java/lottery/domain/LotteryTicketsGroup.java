package lottery.domain;

import java.util.ArrayList;
import java.util.List;
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
            if (isWinner(targetLotteryTicket, lastWinnerTicket)) {
                winnerTicketsGroup.add(targetLotteryTicket);
            }
        }
        return winnerTicketsGroup;
    }

    private boolean isWinner(LotteryTicket candidate, LotteryTicket lastWinnerTicket) {
        long winnerNumberCounts = candidate.getLotteryNumbers().stream()
                .filter(target -> lastWinnerTicket.getLotteryNumbers().stream().anyMatch(Predicate.isEqual(target)))
                .count();
        if (winnerNumberCounts >= MINIMUM_WINNER_NUMBER_COUNTS)
            return true;
        return false;
    }
}
