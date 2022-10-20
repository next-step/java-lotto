package lotto.controller;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        getResult(generateLottos(inputMoney(), inputManualLottoCount()));
    }

    private Lottos generateLottos(Money money, int manualLottoCount) {
        Lottos lottos = lottoGenerator.generateLottos(money.buyManualLotto(manualLottoCount), inputManualLotto(manualLottoCount));
        printLottos(manualLottoCount, lottos.getLottos());
        return lottos;
    }

    private void getResult(Lottos lottos) {
        printLottoResult(lottos.getResult(inputWinningNumbers(), inputBonusBall()));
    }
}
