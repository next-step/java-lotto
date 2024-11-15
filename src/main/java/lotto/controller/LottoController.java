package lotto.controller;

import java.util.List;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinningLotto;
import lotto.dto.RankResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final LottoStore store = new LottoStore(new RandomLottoNumberGenerator());

    public Lottos buy() {
        Money fee = new Money(InputView.readAmount());
        List<String> passivityLostts = InputView.readPassivityLostts();
        Lottos lottos = store.buy(fee, passivityLostts);

        OutputView.renderingLottos(lottos);
        return lottos;
    }

    public RankResult check(String winningNumbers, int bonus, Lottos lottos) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonus);
        return new RankResult(lottos.matchAll(winningLotto));
    }
}
