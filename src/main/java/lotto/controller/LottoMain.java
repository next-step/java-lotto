package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame();

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        int manualBuyCount = inputView.inputManualBuyPrice();
        int autoBuyCount = buyCount - manualBuyCount;
        lottoGame.purchaseLotteries(autoBuyCount);
        List<String> manualLottoList = inputView.inputManualLotto(manualBuyCount);
        resultView.resultBuyPrice(autoBuyCount,manualBuyCount);
        resultView.resultLottoList(lottoGame.resolveManualLottoList(manualLottoList));
        String winningNumber = inputView.inputWinningLottoNumber();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLottoNumbers winningLottoNumbers = lottoGame.getWinningNumbers(winningNumber, bonusNumber);
        WinningStatistics winningStatistics = lottoGame.getWinning(winningLottoNumbers);
        resultView.resultStatistics(winningStatistics);
    }
}
