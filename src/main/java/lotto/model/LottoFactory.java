package lotto.model;

import java.util.List;

public class LottoFactory {
    public int calcPrize(LottoNumberBonus lottoNumberBonus, List<LottoTicket> tickets) {
        int prize = 0;
        LottoStatistics lottoStatistics = new LottoStatistics();

        for (LottoTicket ticket : tickets) {
            Rank rank = ticket.announceRank(lottoNumberBonus.getLottoNumbers(), lottoNumberBonus.getBonus());
            lottoStatistics.gatherResult(rank);
            prize += lottoStatistics.getPrizeMoney(rank);
        }

        return prize;
    }

}
