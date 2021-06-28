package lottogame.controller;

import lottogame.model.Lotto;
import lottogame.model.LottoNumber;
import lottogame.model.WinningLottoNumbers;
import lottogame.model.WinningStatistics;
import lottogame.service.LottoGame;
import lottogame.view.InputView;
import lottogame.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGame = new LottoGame();

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());
        int manualBuyCount = inputView.inputManualBuyPrice();
        int autoBuyCount = buyCount - manualBuyCount;

        List<String> manualLottoList = inputView.inputManualLotto(manualBuyCount);
        outputView.resultBuyPrice(autoBuyCount, manualBuyCount);

        lottoGame.purchaseManualLottoList(manualLottoList);
        lottoGame.purchaseAutoLottoList(autoBuyCount);
        outputView.resultLottoList(lottoGame.getLottos());
        Lotto winningLotto = lottoGame.getWinningLotto(inputView.inputWinningLottoNumber());
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLotto, bonusNumber);
        WinningStatistics winningStatistics = lottoGame.getWinning(winningLottoNumbers);
        outputView.resultStatistics(winningStatistics);

    }
}
