package lotto.view;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class ResultView {
    private static final String RESPONSE_LOTTO_COUNT = "%s개를 구매했습니다.\n";
    private static final String RESPONSE_INIT_MESSAGE = "당첨 통계";
    private static final String RESPONSE_INIT_LINE = "---------";
    private static final String RESPONSE_MATCH_MESSAGE = "%s개 일치 (%s원)- %s개\n";
    private static final String RESPONSE_TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public static void responseLottoCount(int purchaseLottoCount) {
        System.out.format(RESPONSE_LOTTO_COUNT, purchaseLottoCount);
    }

    public static void responseLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void responseStatistics(Calculator calculator) {
        System.out.println(RESPONSE_INIT_MESSAGE);
        System.out.println(RESPONSE_INIT_LINE);

        for (LottoResult lottoResult : calculator.getLottoResults()) {
            System.out.format(RESPONSE_MATCH_MESSAGE, lottoResult.getRank().getMatchCount(), lottoResult.getRank().getWinningMoney(), lottoResult.getNumberOfTimes());
        }

        System.out.format(RESPONSE_TOTAL_EARNING_RATE_MESSAGE, calculator.getEarnRate());
    }
}
