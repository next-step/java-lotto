package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoStore lottoStore;

    public LottoGame(InputView inputView, ResultView resultView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoStore = lottoStore;
    }

    public void start() {
        Money money = initMoney();

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buy(money, new RandomLottoStrategy());

        resultView.printPickedLottoNumbers(pickedLottoNumbers);

        LottoNumbers winningLotto = initLottoNumbers();
        WinningInfo winningInfo = WinningInfo.of(pickedLottoNumbers, winningLotto);

        resultView.printWinningStatic(winningInfo, money);
    }

    private LottoNumbers initLottoNumbers() {
        resultView.printWinningLotto();

        List<Integer> inputLottoNumber = inputView.inputLottoNumber();
        return new LottoNumbers(inputLottoNumber);
    }

    private Money initMoney() {
        resultView.printMoney();

        int inputMoney = inputView.inputMoney();
        return new Money(inputMoney);
    }
}
