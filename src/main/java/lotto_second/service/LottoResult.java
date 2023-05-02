package lotto_second.service;

import lotto_second.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Integer> resultMap = new HashMap<>();
    private int totalTicketCount;


    public void calculateResult(LottoTickets tickets, LottoWinner lottoWinner) {
        this.totalTicketCount = tickets.size();
        Set<LottoNumber> winnerNumbers = lottoWinner.getWinnerNumbers();
        LottoNumber bonusNumber = lottoWinner.getBonusNumber();

        for (Lotto ticket : tickets.getLottoTickets()) {
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

        Map<Rank, Integer> rankCountMap = resultMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));

        int totalRevenue = rankCountMap.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .reduce(0, Integer::sum);

        return (double) totalRevenue / (totalTicketCount * 1000);
    }


}
