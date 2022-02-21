package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoResult getMatchWinning(WinningLotto winningLotto, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        lottoTicket.forEach(
            lotto -> lottoResult.matchCounting(
                lotto.matchWinningLotto(winningLotto),
                lotto.matchBonusNumber(bonusNumber))
        );

        return lottoResult;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
