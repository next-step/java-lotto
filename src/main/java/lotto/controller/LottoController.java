package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.utils.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money initialMoney = InputView.acceptPuchaseAmount();
        Lottos manualLottos = new Lottos(LottoGenerator.generate(InputView.acceptManualLottos()));

        Money changes = initialMoney.buyLotto(manualLottos.count());
        Lottos autoLottos = new Lottos(LottoGenerator.generate(changes));
        ResultView.printInput(manualLottos, autoLottos);

        WinningLotto winningLotto = InputView.acceptWinningLotto();
        Result result = winningLotto.makeResult(manualLottos.join(autoLottos));

        ResultView.printResult(initialMoney, result);
    }
}
