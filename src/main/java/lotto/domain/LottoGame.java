package lotto.domain;

import lotto.strategy.AutoLottoStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private LottoTickets tickets;
    private Map<Rank, Integer> results;

    public LottoGame(LottoTickets tickets) {
        this.tickets = tickets;
        initResults();
    }

    public LottoGame(LottoTickets tickets, Map<Rank, Integer> results) {
        this.tickets = tickets;
        this.results = results;
    }


    public LottoTickets getTickets() {
        return tickets;
    }
    
    public Map<Rank, Integer> getResults() {
        return results;
    }

    public void generateAutoLottoNumbers(AutoLottoStrategy autoLottoStrategy) {
        tickets.generateAllLottoNumbers(autoLottoStrategy);
    }

    private void initResults() {
        results = new HashMap<Rank, Integer>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void gameStart(List<Integer> winningNumbers) {
        for (LottoTicket ticket : tickets.getLottoTickets()) {
            int matchCount = ticket.matchLottoNumbers(winningNumbers);
            Rank rank = Rank.getRankByMatchCount(matchCount);
            results.put(rank, results.get(rank) + 1);
        }
    }

    public double calculateReturnRate() {
        int totalSpent = tickets.getLottoTickets().size() * 1000;
        int totalWon = results.entrySet().stream()
                .mapToInt(e -> e.getKey().getWinningMoney() * e.getValue())
                .sum();
        return (double) totalWon / totalSpent;
    }
}
