package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.Lottos;
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
        Lottos buyLottoList = lotto.lottoGame(lottoCount);
        resultView.PrintThePurchasedLotto(buyLottoList);

        List<String> lastWeekLottoNumber = inputView.getLastWeekLottoNumber();
        String lastWeekBounusLottoNumber = inputView.getLastWeekBonusLottoNumber();
        ResultWinner winner = new ResultWinner();

        EnumMap<Rank, Integer> resultMap = winner.countOfWinner(buyLottoList, lastWeekLottoNumber, lastWeekBounusLottoNumber);
        resultView.PrintTheWinningResults(resultMap, lottoCount);

    }
}
