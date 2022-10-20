package lotto.controller;

import lotto.model.*;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Money money = inputMoney();
        int manualLottoCount = inputManualLottoCount();

        Lottos lottos = lottoGenerator.generateLottos(money.buyManualLotto(manualLottoCount), inputManualLotto(manualLottoCount));
        printLottos(manualLottoCount, lottos.getLottos());

        LottoResult result = lottos.getResult(inputWinningNumbers(), inputBonusBall());
        printLottoResult(result);
    }
}
