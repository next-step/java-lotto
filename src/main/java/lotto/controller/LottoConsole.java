package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConsole {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int money = inputView.inputMoney();
        Lottos manualLottos = inputView.inputManualLottos();
        Lottos lottos = LottoStore.sellAsMuchAsPossible(money - manualLottos.price());

        outputView.printPurchasedLottos(manualLottos, lottos);
        WinningLotto winningLotto = inputView.inputWinningLotto();

        Prizes prizes = manualLottos.merged(lottos).judge(winningLotto);
        outputView.printJudgeResult(lottos.price(), prizes);
    }
}
