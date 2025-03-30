package lotto.domain;

import java.util.Map;

public class LottoGame {
    private LottoTickets tickets;

    public LottoGame(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public LottoTickets getTickets() {
        return tickets;
    }

    public GameResult gameStart(LottoTicket winningTicket) {
        Map<Rank, Integer> results = tickets.match(winningTicket);
        return new GameResult(results, calculateReturnRate(results));
    }

    private double calculateReturnRate(Map<Rank, Integer> results) {
        int totalSpent = tickets.getCount() * LottoTickets.LOTTO_PRICE; // 로또 구매 비용 계산
        int totalWon = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
        return (double) totalWon / totalSpent;
    }

}
