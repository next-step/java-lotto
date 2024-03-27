package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoGame(InputView inputView, ResultView resultView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        Money money = initMoney();

        Lottos lottos = lottoGenerator.buy(money, new RandomLottoStrategy());

        resultView.printPickedLottoNumbers(lottos);

        Lotto winningLotto = initLottoNumbers();
        LottoNumber bonusNumber = initBonusNumber();
        WinningInfo winningInfo = WinningInfo.of(lottos, bonusNumber, winningLotto);

        resultView.printWinningStatic(winningInfo, money);
    }

    private Lotto initLottoNumbers() {
        resultView.printWinningLotto();
        List<Integer> inputLottoNumber = inputView.inputLottoNumber();

        return new Lotto(inputLottoNumber);
    }

    private LottoNumber initBonusNumber() {
        resultView.printBonusNumber();
        int bonusNumber = inputView.inputBonusNumber();

        return new LottoNumber(bonusNumber);
    }

    private Money initMoney() {
        resultView.printMoney();

        int inputMoney = inputView.inputMoney();
        return new Money(inputMoney);
    }
}
