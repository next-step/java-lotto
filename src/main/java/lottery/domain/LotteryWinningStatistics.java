package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryWinningStatistics {

    private Map<LotteryRank, Integer> rankCountMap;

    public LotteryWinningStatistics(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        rankCountMap = convertToRankCountMap(convertToRanks(winningTicket, tickets));
    }

    private Map<LotteryRank, Integer> convertToRankCountMap(List<LotteryRank> ranks) {
        return Arrays.stream(LotteryRank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> count(ranks, rank)
                ));
    }

    private int count(List<LotteryRank> ranks, LotteryRank rank) {
        return (int) ranks.stream()
                .filter(r -> r == rank)
                .count();
    }

    private List<LotteryRank> convertToRanks(WinningTicket winningTicket, List<LotteryTicket> tickets) {
        return tickets.stream()
                .map(lotteryTicket -> winningTicket.raffle(lotteryTicket))
                .collect(Collectors.toList());
    }

    public int countRank(LotteryRank rank) {
        return rankCountMap.get(rank);
    }

    public double revenueRate() {
        double totalPrice = countTickets() * LotteryTicket.PRICE;
        double rate = getWinningMoney() / totalPrice;

        return Math.floor(rate * 100) / 100;
    }

    private int getWinningMoney() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(0, (money, entry) -> money + (entry.getValue() * entry.getKey().revenue),
                        (money1, money2) -> money1 + money2);
    }

    private int countTickets() {
        return rankCountMap.entrySet()
                .stream()
                .reduce(0, (count, entry) -> count + entry.getValue(), (count1, count2) -> count1 + count2);
    }
}
