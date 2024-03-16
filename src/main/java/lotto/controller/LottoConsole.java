package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
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
        Lottos lottos = LottoStore.sellAsMuchAsPossible(money);

        outputView.printPurchasedLottos(lottos);

        Lotto winningLotto = inputView.inputWinningLotto();

        Prizes prizes = lottos.judge(winningLotto);
        outputView.printJudgeResult(lottos.price(), prizes);
    }
}
