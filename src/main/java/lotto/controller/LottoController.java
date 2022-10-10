package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Lottos lottos = lottoGenerator.generateLottos(InputView.inputMoney());
        OutputView.printLotto(lottos.getLottos());

        LottoResult result = lottos.getResult(InputView.inputWinningNumbers());
    }
}
