package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottosStatistics;
import lotto.domain.LottoRank;

import java.util.List;

public class OutputView {
    static class TEXT {
        public static String BOUGHT_LOTTO_COUNT = "개를 구매했습니다.";
        public static String TITLE_WINNING_LOTTO_RESULT = "당첨 통계";
        public static String DASH_BAR = "---------------";
    }

    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + TEXT.BOUGHT_LOTTO_COUNT);
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoStatistics(LottosStatistics lottosStatistics) {
        System.out.println(TEXT.TITLE_WINNING_LOTTO_RESULT);
        System.out.println(TEXT.DASH_BAR);

        List<LottoRank> lottoRanks = LottoRank.getWinningLotto(false);
        for (LottoRank lottoRank : lottoRanks) {
            System.out.println(StatisticsString.of(lottosStatistics).getWinningCountString(lottoRank));
        }
        System.out.println(StatisticsString.of(lottosStatistics).getStringRateOfReturnAmount());
    }
}
