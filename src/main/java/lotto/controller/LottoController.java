package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoShuffleStrategy;
import lotto.domain.ResultWinner;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

public class LottoController {

    public static void main(String[] args) {

        int lottoCount = InputView.buyOfLottoPrice();

        LottoGame lotto = new LottoGame();

        List<List<Integer>> buyLottoList = lotto.lottoGame(lottoCount, new LottoShuffleStrategy());

        ResultView.buyLottoList(buyLottoList);

        String lastWeekLottoNumber = InputView.getLastWeekLottoNumber();

        ResultWinner winner = new ResultWinner();

        Map<Integer, Integer> resultMap = winner.countOfWinner(buyLottoList, lastWeekLottoNumber);

        ResultView.resultView(resultMap, lottoCount);

    }
}
