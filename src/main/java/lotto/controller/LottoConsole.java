package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
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
        Money money = inputView.inputMoney();
        List<Lotto> manualLottoList = inputView.inputManualLottos();
        Lottos manualLottos = LottoStore.sellManual(manualLottoList, money);
        Lottos lottos = LottoStore.sellAutomatic(money);

        outputView.printPurchasedLottos(manualLottos, lottos);
        WinningLotto winningLotto = inputView.inputWinningLotto();

        Prizes prizes = manualLottos.merged(lottos).judge(winningLotto);
        outputView.printJudgeResult(lottos.price(), prizes);
    }
}
