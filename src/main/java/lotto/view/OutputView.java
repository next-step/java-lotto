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
        public static String RETURN_VALUE_PREFIX = "총 수익률은 ";
        public static String RETURN_VALUE_POSTFIX = "입니다.";
        public static String RETURN_VALUE_JUDGE = "(기준이 1이기 때문에 결과적으로 ";
        public static String RETURN_VALUE_GAIN = "이득라는 의미임)";
        public static String RETURN_VALUE_LOSS = "손해라는 의미임)";
        public static String DASH = "-";
        public static String SPACE = " ";

        public static String STATISTICS_CONTAIN_WINNING_NUMBER = "개 일치";
        public static String STATISTICS_CONTAIN_BONUS = ", 보너스 볼 일치";
        public static String PARENTHESIS_LEFT = "(";
        public static String PARENTHESIS_RIGHT = ")";
    }

    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + TEXT.BOUGHT_LOTTO_COUNT);
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    private static String getStringRateOfReturnAmount(LottosStatistics lottosStatistics) {
        return new StringBuilder().append(TEXT.RETURN_VALUE_PREFIX)
                .append(lottosStatistics.getRateOfReturnAmount())
                .append(TEXT.RETURN_VALUE_POSTFIX)
                .append(TEXT.RETURN_VALUE_JUDGE)
                .append(lottosStatistics.getRateOfReturnAmount() > 1 ?
                        TEXT.RETURN_VALUE_GAIN : TEXT.RETURN_VALUE_LOSS).toString();
    }

    private static String getStringWinningLottoResult(LottoRank lottoRank, LottosStatistics lottosStatistics) {
        return new StringBuilder()
                .append(lottoRank.getContainCountsSameWinningNumber())
                .append(TEXT.STATISTICS_CONTAIN_WINNING_NUMBER)
                .append(lottoRank.isBonus() ? TEXT.STATISTICS_CONTAIN_BONUS : TEXT.SPACE)
                .append(TEXT.PARENTHESIS_LEFT)
                .append(lottoRank.getWinningAmount())
                .append(TEXT.PARENTHESIS_RIGHT)
                .append(TEXT.SPACE).append(TEXT.DASH).append(TEXT.SPACE)
                .append(lottosStatistics.getWinningCount(lottoRank)).toString();
    }

    public static void printLottoStatistics(LottosStatistics lottosStatistics) {
        System.out.println(TEXT.TITLE_WINNING_LOTTO_RESULT);
        System.out.println(TEXT.DASH_BAR);

        List<LottoRank> lottoRanks = LottoRank.getWinningLotto(false);
        for (LottoRank lottoRank : lottoRanks) {
            System.out.println(getStringWinningLottoResult(lottoRank, lottosStatistics));
        }

        System.out.println(getStringRateOfReturnAmount(lottosStatistics));
    }
}
