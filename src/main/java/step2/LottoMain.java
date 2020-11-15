package step2;

import step2.domain.LottoBuyer;
import step2.dto.LottoStatisticsResult;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        final int money = InputView.plzEnterMoney();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        lottoBuyer.buy();
        
        OutputView.printLottoCount(lottoBuyer.getLottos());
        OutputView.printAllLotto(lottoBuyer.getLottos());
        
        final String winningNumberExpression = InputView.plzEnterLastWeekWinningNumber();
        final LottoStatisticsResult statisticsResult = lottoBuyer.getWinLotteryStatistics(winningNumberExpression);
        OutputView.printStatistics(statisticsResult);
    }
}
