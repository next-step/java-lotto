package lotto;

import lotto.domain.AccordanceCount;
import lotto.domain.LottoShop;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseMoney purchaseMoney = inputView.inputPurchaseMoney();

        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(purchaseMoney);

        ResultView resultView = new ResultView();
        resultView.printLottos(lottos);

        WinningNumbers winningNumbers = inputView.inputLastWeekWinningNumbers();

        LottoStatistics lottoStatistics = new LottoStatistics();
        AccordanceCount accordanceCount = lottoStatistics.collectAccordanceCount(lottos, winningNumbers);
        resultView.printWinningStatistics(accordanceCount);

        double profitRatio = lottoStatistics.calculateProfitRatio(accordanceCount, purchaseMoney);
        resultView.printProfitRatio(profitRatio);
    }
}
