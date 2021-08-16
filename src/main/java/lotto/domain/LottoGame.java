package lotto.domain;

import lotto.domain.dto.LottoPurchaseResponse;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private Lottos lottos;

    public LottoPurchaseResponse purchase(List<Lotto> lottoList) {
        this.lottos = new Lottos(lottoList);
        return new LottoPurchaseResponse(lottos);
    }

    public Map<Award, Long> drawLotto(WinnerLotto winnerLotto) {
        return lottos.drawLottos(winnerLotto);
    }
}
