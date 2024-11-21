package lotto.controller;

import lotto.domain.Games;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Games games = new Games(inputView.askPriceToPay());
        outputView.printPurchasedGames(games);

        LottoNumbers winner = new LottoNumbers(inputView.askWinnerLottoNumber());
        WinningLotto winningLotto = new WinningLotto(winner, inputView.askBonusNumber());
        LottoResult lottoResult = new LottoResult(winningLotto.countPerRank(games), winningLotto.calculateEarningRate(games));

        outputView.printResult(lottoResult);
    }
}
