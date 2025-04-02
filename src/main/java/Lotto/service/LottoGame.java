package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.LottoList;
import Lotto.domain.LottoNumber;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoGame {
    public static void main(String[] args) {
        int purchasedQty = InputView.askHowMuchYouWouldBuy();
        ResultView.printQuantity(purchasedQty);

        LottoList lottoList = new LottoList();
        List<Lotto> lottos = lottoList.generateLottos(purchasedQty);
        ResultView.printLottos(lottos);

        Set<LottoNumber> winningNumbers = InputView.askForWinningNumbers();
        List<Integer> stats = lottoList.calculateStats(winningNumbers);
        ResultView.printStats(stats);

        double profitRate = calculateProfitRate(lottoList, winningNumbers);
        ResultView.printProfitRate(profitRate);
    }

    public static double calculateProfitRate(LottoList lottoList, Set<LottoNumber> winningNumbers) {
        List<Integer> stats = lottoList.calculateStats(winningNumbers);
        int totalPrize = stats.get(3) * 5000 + stats.get(4) * 50000 + stats.get(5) * 1500000 + stats.get(6) * 2000000000;
        int totalSpent = lottoList.getLottos().size() * 1000;

        return totalPrize / (double) totalSpent;
    }
}
