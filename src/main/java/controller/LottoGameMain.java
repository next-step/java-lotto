package controller;

import domain.LottoGame;
import domain.LottoGameResult;
import domain.LottoMoney;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoGameMain {

    public static void main(String args[]) {
        LottoMoney money = InputView.getLottoCountFromInputMoney();
        LottoGame lottoGame = new LottoGame(money.getNumberOfLotto());

        lottoGame.printUserLottos();

        WinningLotto winningLotto = InputView.getWinnerNoByInput();

        LottoGameResult result = lottoGame.getMultipleResults(winningLotto);

        ResultView.printWinningStatistics(result);
        ResultView.printProfitRate(result, money.getMoney());

    }
}
