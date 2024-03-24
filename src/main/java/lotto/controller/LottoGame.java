package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoStore lottoStore;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        List<Integer> lottoNumberPool = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        this.lottoStore = new LottoStore(new RandomLottoStrategy(lottoNumberPool));
    }

    public void start() {
        Money money = initMoney();

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buy(money);

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
