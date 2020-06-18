package lotto.model;

import java.util.List;

public class LottoFactory {
    public int gameStart(int numberOfTickets, int[] winningNumbers, List<LottoTicket> tickets) {
        int prize = 0;
        LottoStatistics lottoStatistics = new LottoStatistics();

        for (int i = 0; i < numberOfTickets; i++) {
            Rank rank = tickets.get(i).announceRank(winningNumbers);
            lottoStatistics.gatherResult(rank);
            prize += lottoStatistics.getPrizeMoney(rank);
        }

        return prize;
    }

}
