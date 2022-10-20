package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Money money = inputMoney();
        int manualLottoCount = inputManualLottoCount();

        Lottos lottos = lottoGenerator.generateLottos(money.buyManualLotto(manualLottoCount), inputManualLotto(manualLottoCount));
        printLotto(lottos.getLottos());

        LottoResult result = lottos.getResult(inputWinningNumbers(), inputBonusBall());
        printLottoResult(result);
    }
}
