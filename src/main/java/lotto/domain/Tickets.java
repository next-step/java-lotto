package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Tickets {

    private final List<Ticket> values;

    public Tickets(List<Ticket> tickets) {
        this.values = tickets;
    }

    public List<Ticket> values() {
        return values;
    }

    public Map<Rank, Integer> countWinningTickets(WinningNumbers winningNumbers) {
        Map<Rank, Integer> matchRankCountMap = new EnumMap<>(Rank.class);
        initMatchRankCountMap(matchRankCountMap);
        values.forEach(ticket -> {
            int countOfWinningNumber = ticket.countWinningNumber(winningNumbers);
            Rank rank = Rank.valueOfRank(countOfWinningNumber,
                ticket.isBonusNumberContained(winningNumbers));
            matchRankCountMap.put(rank, matchRankCountMap.get(rank) + 1);
        });
        return Collections.unmodifiableMap(matchRankCountMap);
    }

    public double calculateRateOfBenefit(Map<Rank, Integer> matchRankCountMap, long purchaseAmount) {
        AtomicLong benefitSum = new AtomicLong();
        matchRankCountMap.forEach((rank, integer) -> benefitSum.set(
            benefitSum.get() + rank.winningMoney() * matchRankCountMap.get(rank)));
        return Math.round((double) benefitSum.get() / purchaseAmount * 100.00) / 100.00;
    }

    public int getCountOfTickets() {
        return values.size();
    }

    private void initMatchRankCountMap(Map<Rank, Integer> matchRankCountMap) {
        for (Rank rank : Rank.values()) {
            matchRankCountMap.put(rank, 0);
        }
    }
}
