package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRankingBoard;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoRankingBoard lottoRankingBoard = new LottoRankingBoard();
        Money money = inputView.inputMoney();
        List<Lotto> lottos = Lotto.buyLotto(money);
        resultView.printBoughtResult(lottos);
        List<Integer> winningNumbers = inputView.inputLastWeekWinningNumbers();
        Map<Rank, Integer> lottoRankings = lottoRankingBoard.getLottoRankings(lottos, new Lotto(winningNumbers));
        long totalReward = lottoRankingBoard.getTotalReward(lottoRankings);
        resultView.printLottoResults(lottoRankings, money.getProfit(totalReward));
    }
}
