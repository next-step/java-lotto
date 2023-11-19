package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoShuffleStrategy;
import lotto.domain.Rank;
import lotto.domain.ResultWinner;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int lottoCount = inputView.buyOfLottoPrice();
        LottoGame lotto = new LottoGame();
        List<List<Integer>> buyLottoList = lotto.lottoGame(lottoCount, new LottoShuffleStrategy());
        resultView.PrintThePurchasedLotto(buyLottoList);

        List<String> lastWeekLottoNumber = inputView.getLastWeekLottoNumber();
        ResultWinner winner = new ResultWinner();

        EnumMap<Rank, Integer> resultMap = winner.countOfWinner(buyLottoList, lastWeekLottoNumber);
        resultView.PrintTheWinningResults(resultMap, lottoCount);

    }
}
