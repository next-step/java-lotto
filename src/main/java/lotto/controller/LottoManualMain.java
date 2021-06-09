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

        lottoGame.getManualLottoList(inputView.inputManualLotto(manualBuyCount));

        resultView.resultLottoList(lottoGame.getLottoList(buyCount - manualBuyCount));

        resultView.resultStatistics(lottoGame.getWinning(lottoGame.getWinningNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber())));

    }
}
