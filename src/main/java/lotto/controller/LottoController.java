package lotto.controller;

import lotto.domain.Games;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
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
        LottoNumber bonusLottoNumber = LottoNumber.bonusLottoNumberOf(inputView.askBonusNumber(), winner);
        LottoResult lottoResult = new LottoResult(winner, bonusLottoNumber, games);

        outputView.printResult(lottoResult);
    }
}
