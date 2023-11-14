package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Tickets {

        private final List<Ticket> values;
        private EnumMap<Rank, Integer> matchRankCountMap = new EnumMap<>(Rank.class);
        private double rateOfBenefit;

        public Tickets(List<Ticket> tickets) {
                this.values = tickets;
        }

        public List<Ticket> tickets() {
                return values;
        }

        public Map<Rank, Integer> matchRankCountMap() {
                return matchRankCountMap;
        }

        public double rateOfBenefit() {
                return rateOfBenefit;
        }

        public void analyzeLottoResults(List<Integer> winningNumbers, long purchaseAmount) {
                countWinningTickets(winningNumbers);
                calculateRateOfBenefit(purchaseAmount);
        }

        private void countWinningTickets(List<Integer> winningNumbers) {
                initMatchRankCountMap();
                values.forEach(ticket -> ticket.matchInOneTicket(winningNumbers));
                values.forEach(
                    ticket -> matchRankCountMap.put(ticket.rank(), matchRankCountMap.get(ticket.rank()) + 1));
        }

        private void initMatchRankCountMap() {
                for (Rank rank : Rank.values()) {
                        matchRankCountMap.put(rank, 0);
                }
        }

        private void calculateRateOfBenefit(long purchaseAmount) {
                AtomicLong benefitSum = new AtomicLong();
                matchRankCountMap.forEach((rank, integer) -> {
                        benefitSum.set(benefitSum.get() + rank.winningMoney() * matchRankCountMap.get(rank));
                });
                rateOfBenefit = Math.round((double) benefitSum.get() / purchaseAmount * 100.00) / 100.00;
        }
}
