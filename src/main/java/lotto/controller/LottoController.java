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
        LottoGame lotto = new LottoGame();
        Lottos buyLottoList = lotto.lottoGame(lottoCount);
        resultView.PrintThePurchasedLotto(buyLottoList);

        Lotto lastWeekLottoNumber = inputView.getLastWeekLottoNumber();
        String lastWeekBounusLottoNumber = inputView.getLastWeekBonusLottoNumber();

        WinningNumber winningNumber = new WinningNumber(lastWeekLottoNumber, Integer.parseInt(lastWeekBounusLottoNumber));
        ResultWinner winner = new ResultWinner();

        EnumMap<Rank, Integer> resultMap = winner.countOfWinner(buyLottoList, winningNumber);
        resultView.PrintTheWinningResults(resultMap, lottoCount);

    }
}
