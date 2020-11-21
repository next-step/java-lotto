package lotto;

import lotto.domain.LottoGame;
import lotto.dto.LottoStatisticsResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        final int money = InputView.plzEnterMoney();
        final List<String> lottoNoList = InputView.plzEnterManuallyBuyLottoNo();

        final LottoGame lottoGame = LottoGame.of(money);
        lottoGame.buyLotto(lottoNoList);

        OutputView.printLottoCount(lottoNoList.size(), lottoGame.getLottoTicketGroup());
        OutputView.printAllLotto(lottoGame.getLottoTicketGroup());

        final String winningNumberExpression = InputView.plzEnterLastWeekWinningNumber();
        final int bonusNumber = InputView.plzEnterBonusNumber();
        final LottoStatisticsResult statisticsResult = lottoGame.getWinLotteryStatistics(winningNumberExpression, bonusNumber);
        OutputView.printStatistics(statisticsResult);
    }
}
