package Lotto.service;

import Lotto.constants.LottoPrize;
import Lotto.domain.Lotto;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {
    public static void main(String[] args) {
        int purchasedQty = InputView.askHowMuchYouWouldBuy();
        ResultView.printQuantity(purchasedQty);

        Lottos lottoList = new Lottos();
        List<Lotto> lottos = lottoList.generateLottos(purchasedQty);
        ResultView.printLottos(lottos);

        Set<LottoNumber> winningNumbers = InputView.askForWinningNumbers();
        Map<LottoPrize, Integer> stats = lottoList.calculateStats(winningNumbers);
        ResultView.printStats(stats);

        double profitRate = calculateProfitRate(lottoList, winningNumbers);
        ResultView.printProfitRate(profitRate);
    }

    public static double calculateProfitRate(Lottos lottoList, Set<LottoNumber> winningNumbers) {
        Map<LottoPrize, Integer> stats = lottoList.calculateStats(winningNumbers);

        int totalPrize = 0;

        for(LottoPrize prize: LottoPrize.values()) {
            totalPrize += stats.get(prize.getMatchCount()) * prize.getPrizeMoney();
        }

        int totalSpent = lottoList.getLottos().size() * 1000;

        return totalPrize / (double) totalSpent;
    }
}
