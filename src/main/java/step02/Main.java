package step02;

import step02.domain.*;
import step02.view.InputView;
import step02.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int payment = InputView.payLotto();

        LottoSeller lottoSeller = LottoSeller.of(Mock.LOTTO_PRICE);
        LottoGenerator lottoGenerator = LottoGenerator.of(Mock.LOTTO_START_NUMBER, Mock.LOTTO_END_NUMBER);

        Lottos userLottos = lottoSeller.generateLottos(payment, lottoGenerator);
        ResultView.showLottoCount(userLottos.getCount());

        ResultView.showLottos(userLottos.print());

        Lotto winningNumbers = Lotto.of(WinningNumberTokenizer.execute(InputView.createWinningNumber(), lottoGenerator));
        LottoRewardCollections lottoRewardCollections = LottoRewardCollections.of(Mock.LOTTO_REWARDS);
        WinningStatistic winningStatistic = WinningStatistic.of(winningNumbers, userLottos, lottoRewardCollections).execute();
        ResultView.showWinningStatistics(winningStatistic.getLottoRewards());

        ResultView.showYield(winningStatistic.calculateGainRate(Mock.LOTTO_PRICE));
    }
}
