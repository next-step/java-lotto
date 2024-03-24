package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printMoney();
        Money money = inputView.inputMoney();

        LottoCount lottoCount = new LottoCount(money);
        LottoStore lottoStore = new LottoStore(new LottoPicker());

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buyLotto(lottoCount);

        resultView.printPickedLottoNumbers(pickedLottoNumbers);

        resultView.printWinningLotto();
        LottoNumbers winningLotto = inputView.inputLottoNumber();

        WinningInfo winningInfo = LottoMatch.countNumbers(pickedLottoNumbers, winningLotto);

        resultView.printWinningStatic(winningInfo, money);
    }
}
