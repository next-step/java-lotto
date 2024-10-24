package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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
