package Lotto.service;

import Lotto.constants.LottoPrize;
import Lotto.domain.Lotto;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.ResultStats;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {
    public static void main(String[] args) {
        int purchasedQty = InputView.askHowMuchYouWouldBuy();
        ResultView.printQuantity(purchasedQty);

        Lottos lottoList = new Lottos(purchasedQty);
        ResultView.printLottos(lottoList.getLottos());

        Set<LottoNumber> winningNumbers = InputView.askForWinningNumbers();
        ResultStats resultStats = new ResultStats(lottoList.getLottos(), winningNumbers);
        ResultView.printStats(resultStats.getStats());

        int totalSpent = purchasedQty * 1000;
        ResultView.printProfitRate(resultStats.calculateProfitRate(totalSpent));
    }
}

