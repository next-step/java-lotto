package lotto.domain;

import lotto.domain.dto.LottoPurchaseResult;

import java.util.List;

public class LottoGame {
    private Lottos lottos;

    public LottoPurchaseResult purchase(List<Lotto> lottoList) {
        this.lottos = new Lottos(lottoList);
        return new LottoPurchaseResult(lottos);
    }

    public LottoDrawResult drawLotto(WinnerLotto winnerLotto) {
        return new LottoDrawResult(lottos.drawLottos(winnerLotto));
    }
}
