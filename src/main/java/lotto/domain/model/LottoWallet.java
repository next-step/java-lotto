package lotto.domain.model;

import lotto.domain.service.LottoResultCalculator;

import java.util.ArrayList;
import java.util.List;


public class LottoWallet {
    private final List<LottoTicket> lottos = new ArrayList<>();

    public void addLotto(LottoTicket lotto) {
        this.lottos.add(lotto);
    }

    public MatchResult countMatches(WinningTicket winningTicket) {
        MatchResult matchResult = LottoResultCalculator.evaluateLottos(winningTicket, this.lottos);
        return matchResult;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public List<LottoTicket> getLottos() {
        return this.lottos;
    }
}
