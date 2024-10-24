package lotto;

import lotto.domain.*;
import lotto.domain.numbergenerator.LottoNumberGenerator;

import java.util.List;

public class LottoGame {
    private Lottos lottos;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator) {

        this.lottos = new Lottos(lottoNumberGenerator.generate());
    }
    public List<LottoNumbers> getLottoNumbers() {
        return lottos.getLottoNumbers();
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        return lottos.getWinningResult(winningLotto);
    }
}
