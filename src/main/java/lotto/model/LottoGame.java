package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private LottoTickets lottoTickets;
    private Set<LottoNumber> winLottoNumbers;

    public LottoGame(LottoTickets lottoTickets, Set<LottoNumber> lottoNumbers) {
        this.lottoTickets = lottoTickets;
        this.winLottoNumbers = lottoNumbers;
    }

    public LottoResult playLotto() {
        List<Rank> rankList = lottoTickets.getRankings(winLottoNumbers);
        return new LottoResult(rankList);
    }
}
