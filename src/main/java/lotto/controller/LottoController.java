package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.swing.*;
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
        Lottos lottos = new Lottos(amount);
        resultView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        resultView.printResults(lottos.getWinningResult(winningLotto), amount);
    }
}
