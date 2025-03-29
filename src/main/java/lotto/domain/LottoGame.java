package lotto.domain;

import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoStrategy;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private LottoTickets tickets;

    public LottoGame(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public LottoTickets getTickets() {
        return tickets;
    }


    private Map<Rank, Integer> initializeResults() {
        // Rank의 모든 값을 초기화하여 결과 맵 생성
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        return results;
    }

    public GameResult gameStart(List<Integer> winningNumbers) {
        Map<Rank, Integer> results = initializeResults();

        // 각 티켓의 당첨 등수를 계산하여 결과 맵에 반영
        tickets.getLottoTickets().stream()
                .map(ticket -> Rank.getRankByMatchCount(ticket.matchLottoNumbers(winningNumbers)))
                .forEach(rank -> results.merge(rank, 1, Integer::sum));

        // 수익률 계산
        double returnRate = calculateReturnRate(results);

        // 결과 객체 생성 및 반환
        return new GameResult(results, returnRate);
    }

    private double calculateReturnRate(Map<Rank, Integer> results) {
        int totalSpent = tickets.getCount() * LottoTickets.LOTTO_PRICE; // 로또 구매 비용 계산
        int totalWon = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
        return (double) totalWon / totalSpent;
    }

}
