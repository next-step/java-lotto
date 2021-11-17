package step2.service;

import step2.domain.*;

public class LottoService {

    public Lottos purchase(int price) {
        return Lottos.purchase(price);
    }

    public WinningResult winningResult(Lottos purchasedLottos, String winningNumbers) {
        WinningLotto winningLotto = WinningLotto.create(winningNumbers);
        return calculate(purchasedLottos, winningLotto);
    }

    private WinningResult calculate(Lottos purchasedLottos, WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.create();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            int matchCount = lotto.match(winningLotto.getLotto());
            WinningType type = WinningType.findBy(matchCount);
            winningResult.addCount(type);
        }
        return winningResult;
    }
}
