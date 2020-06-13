package lotto.view;

import lotto.domain.data.Lotto;
import lotto.domain.LottosStatistics;
import lotto.domain.data.LottoRank;
import lotto.domain.data.ManualLotto;

import java.util.List;

public class OutputView {
    public static void printBuyLottos(List<Lotto> lottos, List<ManualLotto> manualLottos) {
        String summary = String.format(TextFixture.BOUGHT_LOTTO_COUNT, manualLottos.size(), lottos.size() - manualLottos.size());
        System.out.println(summary);
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoStatistics(LottosStatistics lottosStatistics) {
        System.out.println(TextFixture.TITLE_WINNING_LOTTO_RESULT);
        System.out.println(TextFixture.DASH_BAR);

        List<LottoRank> lottoRanks = LottoRank.getWinningLotto(false);
        for (LottoRank lottoRank : lottoRanks) {
            System.out.println(StatisticsString.of(lottosStatistics).getWinningCountString(lottoRank));
        }
        System.out.println(StatisticsString.of(lottosStatistics).getStringRateOfReturnAmount());
    }
}
