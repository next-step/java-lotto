package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottosStatistics;
import lotto.domain.LottoRank;

import java.util.List;

public class OutputView {
    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + TextFixture.BOUGHT_LOTTO_COUNT);
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
