package lotto.domain.numbers;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }

    public LottoResult getMatchLottoResult(final WinningLottoTicket winningLottoTicket) {
        LottoResult lottoResult = new LottoResult();
        lottoTickets.forEach(lottoTicket -> {
            Rank rank = lottoTicket.matchWinningLottoNumbers(winningLottoTicket);
            lottoResult.addRank(rank);
        });
        return lottoResult;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
