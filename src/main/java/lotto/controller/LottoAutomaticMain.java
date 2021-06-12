package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        resultView.resultBuyPrice(buyCount);
        resultView.resultLottoList(lottoGame.purchaseLotteries(buyCount));
        resultView.resultStatistics(lottoGame.getWinning(lottoGame.getWinningNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber())));

    }
}
