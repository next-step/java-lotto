package lotto;

import lotto.domain.LottoBuyer;
import lotto.dto.LottoStatisticsResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        final int money = InputView.plzEnterMoney();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        lottoBuyer.buy();
        
        OutputView.printLottoCount(lottoBuyer.getLottoTickets());
        OutputView.printAllLotto(lottoBuyer.getLottoTickets());
        
        final String winningNumberExpression = InputView.plzEnterLastWeekWinningNumber();
        final int bonusNumber = InputView.plzEnterBonusNumber();
        final LottoStatisticsResult statisticsResult = lottoBuyer.getWinLotteryStatistics(winningNumberExpression, bonusNumber);
        OutputView.printStatistics(statisticsResult);
    }
}
