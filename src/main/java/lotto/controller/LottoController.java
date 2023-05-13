package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        LottoPurchaseAmount amount = LottoPurchaseAmount.of(inputView.readAmount());
        List<List<LottoNumber>> selectedLottoNumbers = inputView.readSelectedLottoNumbers(inputView.readSelectedLottoCount());

        Lottos lottos = new Lottos(amount, selectedLottoNumbers);
        resultView.printLottos(lottos);

        List<LottoNumber> winningNumbers = inputView.readWinningNumbers();
        LottoNumber bonusNumber = new LottoNumber(inputView.readBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        resultView.printResults(lottos.getWinningResult(winningLotto), amount);
    }
}
