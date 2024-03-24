package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printMoney();
        Money money = initMoney();

        LottoCount lottoCount = new LottoCount(money);
        LottoStore lottoStore = new LottoStore(new LottoPicker());

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buyLotto(lottoCount);

        resultView.printPickedLottoNumbers(pickedLottoNumbers);
        resultView.printWinningLotto();

        LottoNumbers winningLotto = initLottoNumbers();
        WinningInfo winningInfo = WinningInfo.of(pickedLottoNumbers, winningLotto);

        resultView.printWinningStatic(winningInfo, money);
    }

    private LottoNumbers initLottoNumbers() {
        List<Integer> inputLottoNumber = inputView.inputLottoNumber();
        return new LottoNumbers(inputLottoNumber);
    }

    private Money initMoney() {
        int inputMoney = inputView.inputMoney();
        return new Money(inputMoney);
    }
}
