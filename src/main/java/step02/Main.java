package step02;

import step02.domain.*;
import step02.view.InputView;
import step02.view.ResultView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int LOTTO_PRICE = 1000;

        int payment = InputView.payLotto();

        LottoSeller lottoSeller = LottoSeller.of(LOTTO_PRICE);
        LottoNumbers lottoNumbers = LottoNumbers.of(1, 46);

        Lottos userLottos = lottoSeller.generateLottos(payment, lottoNumbers);
        ResultView.showLottoCount(userLottos.getCount());

        ResultView.showLottos(userLottos.print());

        Lotto winningNumbers = Lotto.of(Tokenizer.execute(InputView.createWinningNumber()));
        LottoRewardCollections lottoRewardCollections = LottoRewardCollections.of(
                Arrays.asList(
                        LottoReward.of(3, 5000, 0),
                        LottoReward.of(4, 50000, 0),
                        LottoReward.of(5, 1500000, 0),
                        LottoReward.of(6, 2000000000, 0)
                )
        );
        WinningStatistic winningStatistic = WinningStatistic.of(winningNumbers, userLottos, lottoRewardCollections).execute();
        ResultView.showWinningStatistics(winningStatistic.getLottoRewards());

        ResultView.showYield(winningStatistic.calculateGainRate(LOTTO_PRICE));
    }
}
