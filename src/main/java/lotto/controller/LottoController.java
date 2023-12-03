package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.EnumMap;

public class LottoController {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int lottoCount = inputView.buyOfLottoPrice();
        int manualLottoCount = inputView.buyOfManualLotto(lottoCount);
        LottoGame lottoGame = new LottoGame();
        Lottos manualLottos = inputView.getManualLottoNNumbers(manualLottoCount);
        Lottos buyLottos = lottoGame.startGame(lottoCount - manualLottoCount);
        Lottos mergeLottos = new Lottos(manualLottos, buyLottos);
        resultView.PrintThePurchasedLotto(mergeLottos, manualLottos.getLottosSize(), buyLottos.getLottosSize());

        Lotto lastWeekLottoNumber = inputView.getLastWeekLottoNumber();
        LottoNumber lastWeekBounusLottoNumber = inputView.getLastWeekBonusLottoNumber();

        WinningNumber winningNumber = new WinningNumber(lastWeekLottoNumber, lastWeekBounusLottoNumber);
        ResultWinner winner = new ResultWinner();

        EnumMap<Rank, Integer> resultMap = winner.countOfWinner(mergeLottos, winningNumber);
        resultView.PrintTheWinningResults(resultMap, lottoCount);

    }
}
