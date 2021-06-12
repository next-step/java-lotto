package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningStatistics;
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
        String winningNumber = inputView.inputWinningLottoNumber() ;
        int bonusNumber = inputView.inputBonusNumber();
        WinningLottoNumbers winningLottoNumbers = lottoGame.getWinningNumbers(winningNumber,bonusNumber);
        WinningStatistics winningStatistics = lottoGame.getWinning(winningLottoNumbers);
        resultView.resultStatistics(winningStatistics);

    }
}
