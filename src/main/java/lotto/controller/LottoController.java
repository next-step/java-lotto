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
        int manualLottoCount = inputView.buyOfManualLotto();
        LottoGame lotto = new LottoGame();
        Lottos manualLottos = inputView.getManualLottoNNumbers(manualLottoCount);
        Lottos buyLottos = lotto.lottoGame(lottoCount - manualLottoCount);
        Lottos mergeLottos = new Lottos(manualLottos, buyLottos);
        resultView.PrintThePurchasedLotto(mergeLottos, manualLottos.getLottosSize(), buyLottos.getLottosSize());

        Lotto lastWeekLottoNumber = inputView.getLastWeekLottoNumber();
        String lastWeekBounusLottoNumber = inputView.getLastWeekBonusLottoNumber();

        WinningNumber winningNumber = new WinningNumber(lastWeekLottoNumber, Integer.parseInt(lastWeekBounusLottoNumber));
        ResultWinner winner = new ResultWinner();

        EnumMap<Rank, Integer> resultMap = winner.countOfWinner(mergeLottos, winningNumber);
        resultView.PrintTheWinningResults(resultMap, lottoCount);

    }
}
