package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryWinningStatistics {

    private final Map<LotteryRank, TicketCount> rankCountMap;

    public LotteryWinningStatistics(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        rankCountMap = convertToRankCountMap(convertToRanks(winningTicket, tickets));
    }

    private Map<LotteryRank, TicketCount> convertToRankCountMap(List<LotteryRank> ranks) {
        return Arrays.stream(LotteryRank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> count(ranks, rank)
                ));
    }

    private TicketCount count(List<LotteryRank> ranks, LotteryRank rank) {
        return new TicketCount((int) ranks.stream()
                .filter(r -> r == rank)
                .count());
    }

    private List<LotteryRank> convertToRanks(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        return tickets.stream()
                .map(lotteryTicket -> winningTicket.raffle(lotteryTicket))
                .collect(Collectors.toList());
    }

    public TicketCount countRank(LotteryRank rank) {
        return rankCountMap.get(rank);
    }

    public RevenueRate revenueRate() {
        return new RevenueRate(getWinningMoney(), totalTicketsPrice());
    }

    private Money getWinningMoney() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(new Money(0),
                        (sum, entry) -> sum.add(entry.getValue().multiply(entry.getKey().winningMoney.amount).amount),
                        (sum1, sum2) -> sum1.add(sum2.amount));
    }

    private Money totalTicketsPrice() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(new TicketCount(0),
                        (sum, entry) -> sum.add(entry.getValue().amount),
                        (count1, count2) -> count1.add(count2.amount))
                .getPrice();
    }
}
