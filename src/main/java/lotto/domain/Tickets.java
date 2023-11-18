package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Tickets {

        private final List<Ticket> values;
        private Map<Rank, Integer> matchRankCountMap = new EnumMap<>(Rank.class);
        private double rateOfBenefit;

        public Tickets(List<Ticket> tickets) {
                this.values = tickets;
        }

        public Tickets(int[][] tickets) {
                this.values = Arrays.stream(tickets).map(Ticket::new).collect(Collectors.toList());
        }

        public List<Ticket> values() {
                return values;
        }

        public Map<Rank, Integer> matchRankCountMap() {
                return matchRankCountMap;
        }

        public double rateOfBenefit() {
                return rateOfBenefit;
        }

        public void analyzeLottoResults(WinningNumbers winningNumbers, long purchaseAmount) {
                countWinningTickets(winningNumbers);
                calculateRateOfBenefit(purchaseAmount);
        }

        private void countWinningTickets(WinningNumbers winningNumbers) {
                initMatchRankCountMap();
                values.forEach(ticket -> {
                        int countOfWinningNumber = ticket.countWinningNumber(winningNumbers);
                        Rank rank = Rank.valueOfRank(countOfWinningNumber);
                        matchRankCountMap.put(rank, matchRankCountMap.get(rank) + 1);
                });
        }

        private void initMatchRankCountMap() {
                for (Rank rank : Rank.values()) {
                        matchRankCountMap.put(rank, 0);
                }
        }

        private void calculateRateOfBenefit(long purchaseAmount) {
                AtomicLong benefitSum = new AtomicLong();
                matchRankCountMap.forEach((rank, integer) -> benefitSum.set(
                    benefitSum.get() + rank.winningMoney() * matchRankCountMap.get(rank)));
                rateOfBenefit = Math.round((double) benefitSum.get() / purchaseAmount * 100.00) / 100.00;
        }
}
