package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Tickets {

        private final List<Ticket> values;

        public Tickets(List<Ticket> tickets) {
                this.values = tickets;
        }

        public List<Ticket> values() {
                return values;
        }

        public int getCountOfTickets() {
                return values.size();
        }

        public WinningTickets analyzeWinningTickets(WinningNumbers winningNumbers) {
                Map<Rank, Integer> matchRankCountMap = new EnumMap<>(Rank.class);
                initMatchRankCountMap(matchRankCountMap);
                values.forEach(ticket -> {
                        int countOfWinningNumber = ticket.countWinningNumber(winningNumbers);
                        Rank rank = Rank.valueOfRank(countOfWinningNumber, ticket.hasBonusNumber(winningNumbers));
                        matchRankCountMap.computeIfPresent(rank, (k, v) -> v + 1);
                });
                return new WinningTickets(matchRankCountMap);
        }

        private void initMatchRankCountMap(Map<Rank, Integer> matchRankCountMap) {
                for (Rank rank : Rank.values()) {
                        matchRankCountMap.put(rank, 0);
                }
        }
}
