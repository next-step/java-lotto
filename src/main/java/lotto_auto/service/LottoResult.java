package lotto_auto.service;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;
import lotto_auto.domain.LottoWinner;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> resultMap = new HashMap<>();
    private int totalTicketCount;


    public void calculateResult(LottoTickets tickets, LottoWinner lottoWinner) {
        this.totalTicketCount = tickets.size();
        for (Lotto ticket : tickets.getLottoTickets()) {
            int count = countMatchedWinnerLotto(ticket, lottoWinner);
            resultMap.put(count, resultMap.getOrDefault(count, 0) + 1);
        }
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

    public int getCountOfMatch(int matchCount) {
        return resultMap.getOrDefault(matchCount, 0);
    }

    public double getRevenueRate() {
        int totalRevenue = 0;
        totalRevenue += getCountOfMatch(3) * 5000;
        totalRevenue += getCountOfMatch(4) * 50000;
        totalRevenue += getCountOfMatch(5) * 1500000;
        totalRevenue += getCountOfMatch(6) * 2000000000;

        return (double) totalRevenue / (totalTicketCount * 1000);
    }

}
