package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
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
        Money fee = readBuyLottoFee();
        List<String> passivityLottosInput = readPassivityLottos();

        Lottos lottos = buyLottos(passivityLottosInput, fee);

        OutputView.renderingLottos(lottos);
        return lottos;
    }

    private static Money readBuyLottoFee() {
        return new Money(InputView.readAmount());
    }

    private static List<String> readPassivityLottos() {
        return InputView.readPassivityLotts(InputView.readPassivityLottoCount());
    }

    private static Lottos buyLottos(List<String> passivityLottosInput, Money fee) {
        List<Lotto> passivityLottos = store.passivityLostts(passivityLottosInput);
        List<Lotto> autoLottos = store.autoLottos(fee.subtractedBill(passivityLottos.size()));
        Lottos lottos = new Lottos(passivityLottos, autoLottos);
        return lottos;
    }

    public RankResult check(String winningNumbers, int bonus, Lottos lottos) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonus);
        return new RankResult(lottos.matchAll(winningLotto));
    }
}
