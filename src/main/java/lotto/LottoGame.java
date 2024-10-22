package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottoCount lottoCount;
    private Lottos lottos;

    public LottoGame(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
        this.lottos = new Lottos(lottoCount.getLottoNumberGenerator().generate());
    }

    private Lottos createLotto(LottoNumberGenerator lottoNumberGenerator) {
        return new Lottos(lottoNumberGenerator.generate());
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottos.getLottoNumbers();
    }


    public WinningResult getWinningResult(WinningLotto winningLotto) {
        return lottos.getWinningResult(winningLotto);
    }
}
