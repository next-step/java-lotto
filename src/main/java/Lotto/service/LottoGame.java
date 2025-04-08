package Lotto.service;

import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.ResultStats;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.Set;

public class LottoGame {
    public static void main(String[] args) {
        try {
            int purchasedQty = InputView.askHowMuchYouWouldBuy();
            ResultView.printQuantity(purchasedQty);

            Lottos lottoList = new Lottos(purchasedQty);
            ResultView.printLottos(lottoList.getLottos());

            Set<LottoNumber> winningNumbers = InputView.askForWinningNumbers();
            LottoNumber bonusNumber = InputView.askForBonusNumber();
            ResultStats resultStats = new ResultStats(lottoList.getLottos(), winningNumbers, bonusNumber);
            ResultView.printStats(resultStats.getStats());

            int totalSpent = purchasedQty * 1000;
            ResultView.printProfitRate(resultStats.calculateProfitRate(totalSpent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

