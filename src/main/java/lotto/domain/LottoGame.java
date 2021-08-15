package lotto.domain;

import lotto.domain.dto.LottoPurchaseResponse;

import java.util.List;

public class LottoGame {
    private Lottos lottos;

    public LottoPurchaseResponse purchase(List<Lotto> lottoList) {
        this.lottos = new Lottos(lottoList);
        return new LottoPurchaseResponse(lottos);
    }

    public LottoDrawResponse drawLotto(Lotto winnerLotto) {
        return lottos.drawLottos(winnerLotto);
    }
}
