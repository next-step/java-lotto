package lotto.domain.numbers;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }

    public List<Rank> matchWinningLotto(final WinningLottoTicket winningLottoTicket) {
        List<Rank> lottoResult = new ArrayList<>();
        lottoTickets.forEach(lottoTicket -> lottoResult.add(lottoTicket.matchWinningLotto(winningLottoTicket)));
        return lottoResult;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
