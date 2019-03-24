package controller;

import domain.LottoGame;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

import java.util.Map;

public class LottoGameMain {

    public static void main(String args[]) {
        int lottoCount = InputView.getLottoCountFromInputMoney();
        LottoGame lottoGame = new LottoGame(lottoCount);

        lottoGame.printUserLottos();

        WinningLotto winningLotto = InputView.getWinnerNoByString();

        Map<Integer, Integer> result = lottoGame.getMultipleResults(winningLotto);

        ResultView.printWinningStatistics(result);
        ResultView.printProfitRate(result, lottoCount * 1000);

    }
}
