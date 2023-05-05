package lotto;

import lotto.utility.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LotteryTickets;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LotteryTickets lotteryTickets = new LotteryTickets();

        lotteryTickets.purchase(InputConverter.convertBudgetToNumberOfPurchase(InputView.askBudget()));
        List<Lotto> lottoBundle = lotteryTickets.getLottoBundle();

        ResultView resultView = new ResultView();
        resultView.showMyLotto(lottoBundle);

        String strList = InputView.askLastLottoNumber();


        WinningStatistics winningStatistics = new WinningStatistics(InputConverter.convertNumberToList(strList));

        resultView.showStatistic(winningStatistics.lottoResult(lottoBundle), lotteryTickets.getInvestment());
    }

}
