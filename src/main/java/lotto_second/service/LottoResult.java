package lotto_second.service;

import lotto_second.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        boolean matchBonus = ticket.getNumbers().contains(lottoWinner.getBonusNumber());
        return Rank.valueOf(countOfMatch, matchBonus);
    }


    private int countMatchedWinnerLotto(Lotto ticket, LottoWinner lottoWinner) {
        int count = 0;
        for (LottoNumber number : ticket.getNumbers()) {
            count += isWinnerNumber(number, lottoWinner);
        }
        return count;
    }

    private int isWinnerNumber(LottoNumber number, LottoWinner lottoWinner) {
        if (lottoWinner.getWinnerNumbers().contains(number)) {
            return 1;
        }
        return 0;
    }

    public int getCountOfMatch(Rank matchCount) {
        return resultMap.getOrDefault(matchCount, 0);
    }

    public double getRevenueRate() {
        int totalRevenue = resultMap.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();

        return (double) totalRevenue / (totalTicketCount * 1000);
    }


}
