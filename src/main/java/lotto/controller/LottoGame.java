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

    private final List<Integer> lottoNumberPool;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoNumberPool = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public void start() {
        resultView.printMoney();
        Money money = initMoney();
        LottoStore lottoStore = new LottoStore(new RandomLottoStrategy(lottoNumberPool));

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buy(money);

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
