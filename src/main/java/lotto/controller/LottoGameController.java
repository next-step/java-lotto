package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoGameController {

    public Lottos purchaseLottos(PurchaseLottosRequest request) {
        return Lottos.from(request.purchasingLottoSize());
    }

    public LottoResult retrieveStatistics(RetrieveStatisticsRequest request) {
        return request.getLottos()
                .lottoResult(request.winningLotto(), request.bonusLottoNumber());
    }
}
