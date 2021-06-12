package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoManualMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        int manualBuyCount = inputView.inputManualBuyPrice();
        lottoGame.purchaseLotteries(buyCount - manualBuyCount);

        resultView.resultLottoList( lottoGame.resolveManualLottoList(inputView.inputManualLotto(manualBuyCount)));

        resultView.resultStatistics(lottoGame.getWinning(lottoGame.getWinningNumbers(inputView.inputWinningLottoNumber(), inputView.inputBonusNumber())));

    }
}
