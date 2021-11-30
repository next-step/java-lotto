package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money purchasedAmount = InputView.acceptPuchaseAmount();
        Lottos manualLottos = createManualLottos(InputView.acceptManualLottos());

        Money changes = purchasedAmount.changesAfterBuyManual(manualLottos.count());
        Lottos autoLottos = changes.buyAutoLottosAll();
        ResultView.printInput(manualLottos, autoLottos);

        WinningLotto winningLotto = InputView.acceptWinningLotto();
        Result result = winningLotto.makeResult(manualLottos.join(autoLottos));

        ResultView.printResult(purchasedAmount, result);
    }

    private Lottos createManualLottos(List<List<String>> manualLottos) {
        return new Lottos(manualLottos.stream()
                                      .map(lottoNumbers -> Lotto.from(lottoNumbers))
                                      .collect(Collectors.toList()));
    }
}
