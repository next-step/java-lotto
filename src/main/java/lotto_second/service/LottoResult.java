package lotto_second.service;

import lotto_second.domain.Lotto;
import lotto_second.domain.LottoWinner;
import lotto_second.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> resultMap = new HashMap<>();
    private int totalTicketCount;


    public void calculateResult(List<Lotto> tickets, LottoWinner lottoWinner) {
        this.totalTicketCount = tickets.size();

        for (Lotto ticket : tickets) {
            Rank rank = getRank(ticket, lottoWinner);
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank getRank(Lotto ticket, LottoWinner lottoWinner) {
        int countOfMatch = countMatchedWinnerLotto(ticket, lottoWinner);
        boolean matchBonus = matchBonus(ticket, lottoWinner);
        return Rank.findRank(countOfMatch, matchBonus);
    }

    private boolean matchBonus(Lotto ticket, LottoWinner lottoWinner) {
        return ticket.contains(lottoWinner.getBonusNumber());
    }


    private int countMatchedWinnerLotto(Lotto ticket, LottoWinner lottoWinner) {
        return (int) ticket.getNumbers().stream()
                .filter(lottoWinner.getWinnerNumbers()::contains)
                .count();
    }


    public int getCountOfMatch(Rank matchCount) {
        return resultMap.getOrDefault(matchCount, 0);
    }

    public double getRevenueRate() {
        int totalRevenue = resultMap.entrySet()
                .stream()
                .mapToInt(entry -> {
                    int winningMoney = entry.getKey().getWinningMoney();
                    int count = entry.getValue();
                    return winningMoney * count;
                })
                .sum();

        return (double) totalRevenue / (totalTicketCount * 1000);
    }


}
