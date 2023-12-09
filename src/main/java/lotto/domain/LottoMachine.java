package lotto.domain;

import java.util.List;

public class LottoMachine {
    public LottoTicket generateLottoTicket(Lotto lotto) {
        LottoTicket lottoTicket = new LottoTicket(lotto);
        return lottoTicket;
    }
    public LottoTicket generateLottoTicket(int number) {
        LottoTicket lottoTicket = new LottoTicket(number);
        return lottoTicket;
    }
    public Rank rank(Lotto lotto, Lotto winningLotto, LottoStatistics lottoStatistics, int bonusNo) {
        int matchCount = lotto.match(winningLotto);
        Boolean matchBonus = lotto.matchBonus(bonusNo);
        if (matchBonus) {
            matchCount++;
        }
        Rank rank = Rank.rank(matchCount, matchBonus);
        lottoStatistics.addRank(rank);
        return rank;
    }
}
