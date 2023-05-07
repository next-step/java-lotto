package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Reward;
import lotto.domain.WinningStatistics;
import lotto.util.LottoUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        lotto();
    }

    public static void lotto() {

        int lottoBuyPrice = Integer.parseInt(inputView.setBuyLottoPrice());

        int lottoGameCount = LottoUtils.getLottoGameCount(lottoBuyPrice);

        Lotto lotto = new Lotto();
        lotto.buyLottoGames(lottoGameCount);

        List<LottoGame> lottoGames = lotto.getLottoGames();

        resultView.showBuyLotto(lottoGameCount);
        resultView.showMyLottoGameList(lottoGames);

        WinningStatistics winningStatistics = new WinningStatistics(LottoUtils.lottoResultNumberList(inputView.setLottoResultNumber()));
        winningStatistics.makeResultMap();

        Map<Integer, Integer> resultGameStatistics = winningStatistics.resultLottoGame(lottoGames);

        Reward reward = new Reward();
        int totalMatchPrice = reward.sumTotalMatchPrice(resultGameStatistics);
        double rateOfReturn = winningStatistics.calRateOfReturn(totalMatchPrice, lottoBuyPrice);

        resultView.resultGame(resultGameStatistics, rateOfReturn);
    }
}
