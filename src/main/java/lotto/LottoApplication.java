package lotto;

import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LotteryTickets;
import lotto.domain.WinningStatistics;
import lotto.exception.BudgetException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputConverter inputConverter = new InputConverter();
        LotteryTickets lotteryTickets = new LotteryTickets();

        int numberOfPurchase = inputConverter.convertBudgetToNumberOfPurchase(InputView.askBudget());

        lotteryTickets.purchase(numberOfPurchase);
        List<Lotto> lottoBundle = lotteryTickets.getLottoBundle();

        ResultView resultView = new ResultView();
        resultView.showMyLotto(lottoBundle);

        String strList = InputView.askLastLottoNumber();


        WinningStatistics winningStatistics = new WinningStatistics(inputConverter.convertNumberToList(strList));

        winningStatistics.compareWithTargetNumber(lottoBundle);
        resultView.showStatistic(winningStatistics.lottoResult(lottoBundle), Lotto.PRICE);
    }

}
