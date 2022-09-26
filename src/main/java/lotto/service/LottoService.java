package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.LottoResult;
import lotto.view.LottoStatistics;

public class LottoService {
    private Lottos lottos;

    public LottoResult buyLotto(int money) {
        return LottoResult.of(buy(money));
    }

    public Lottos buy(int money) {
        int quantity = getQuantity(money);
        lottos = Lottos.create(quantity);
        return lottos;
    }

    private int getQuantity(int money) {
        return money / Lotto.PRICE;
    }

    public LottoStatistics lottoStatistics(String winningNumber) {
        return new LottoStatistics(lottos, createLotto(winningNumber));
    }

    private static Lotto createLotto(String lottoNumbers) {
        return Lotto.create(lottoNumbers);
    }
}
