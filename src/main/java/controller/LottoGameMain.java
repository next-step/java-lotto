package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String args[]) {
        LottoMoney money = InputView.getLottoCountFromInputMoney();
        int manualLottoCount = InputView.getNumberOfManualLottos();
        LottoGame lottoGame;

        if (manualLottoCount > 0) {
            List<Lotto> userLottos = InputView.getUserLottos(manualLottoCount);
            lottoGame = new LottoGame(money, userLottos);
        } else {
            lottoGame = new LottoGame(money);
        }

        InputView.printNumberOfLottos(money, manualLottoCount);
        lottoGame.printUserLottos();

        WinningLotto winningLotto = InputView.getWinnerNoByInput();

        LottoGameResult result = lottoGame.getMultipleResults(winningLotto);

        ResultView.printWinningStatistics(result);
        ResultView.printProfitRate(result, money.getMoney());

    }
}
