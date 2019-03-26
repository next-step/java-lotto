package lottery.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryWinningStatistics {

    private final Map<LotteryRank, TicketCount> rankCountMap;

    public LotteryWinningStatistics(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        rankCountMap = convertToRankCountMap(winningTicket, tickets);
    }

    private Map<LotteryRank, TicketCount> convertToRankCountMap(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        return tickets.stream()
                .map(winningTicket::raffle)
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> TicketCount.valueOf(1),
                        (count1, count2) -> count1.add(count2.amount),
                        () -> new EnumMap<>(LotteryRank.class)
                ));
    }

    public TicketCount countRank(LotteryRank rank) {
        return rankCountMap.getOrDefault(rank, TicketCount.ZERO);
    }

    public RevenueRate revenueRate() {
        return new RevenueRate(getWinningMoney(), totalTicketsPrice());
    }

    private Money getWinningMoney() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(Money.ZERO,
                        (sum, entry) -> sum.add(entry.getValue().times(entry.getKey().winningMoney.amount).amount),
                        (sum1, sum2) -> sum1.add(sum2.amount));
    }

    private Money totalTicketsPrice() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(TicketCount.ZERO,
                        (sum, entry) -> sum.add(entry.getValue().amount),
                        (count1, count2) -> count1.add(count2.amount))
                .getPrice();
    }
}
