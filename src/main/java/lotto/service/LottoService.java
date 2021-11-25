package lotto.service;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

public class LottoService {

    public Result matchLotto(List<Lotto> lottos, Lotto winningNumber) {
        Lottos purchasedLottos = new Lottos(lottos);
        return purchasedLottos.makeResult(winningNumber);
    }
}
