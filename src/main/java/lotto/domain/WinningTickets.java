package lotto.domain;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class WinningTickets {

        private final Map<Rank, Integer> values;

        public WinningTickets(Map<Rank, Integer> values) {
                this.values = values;
        }

        public Map<Rank, Integer> values() {
                return values;
        }

        public double calculateRateOfBenefit(long purchaseAmount) {
                AtomicLong benefitSum = new AtomicLong();
                values.forEach((rank, integer) -> benefitSum.set(
                    benefitSum.get() + rank.winningMoney() * values.get(rank)));
                return Math.round((double) benefitSum.get() / purchaseAmount * 100.00) / 100.00;
        }

        @Override
        public String toString() {
                return values.toString();
        }

        public int countOfWinningTickets() {
                return values.values().stream().reduce(0, Integer::sum) - values.get(Rank.MISS);
        }
}
