package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;

import java.util.List;

public class ResultView {
    private static final String RESPONSE_LOTTO_COUNT = "%s개를 구매했습니다.\n";
    private static final String RESPONSE_INIT_MESSAGE = "당첨 통계";
    private static final String RESPONSE_INIT_LINE = "---------";
    private static final String RESPONSE_MATCH_MESSAGE = "%s개 일치 (%s원)- %s개\n";
    private static final String RESPONSE_TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public static void responseLottoCount(int purchaseLottoCount) {
        System.out.format(RESPONSE_LOTTO_COUNT, purchaseLottoCount);
    }

    public static void responseLottoNumbers(LottoDto lottoDto) {
        for (Lotto lotto : lottoDto.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void responseWinningStatistics(StatisticsDto statisticsDtoo) {
        System.out.println(RESPONSE_INIT_MESSAGE);
        System.out.println(RESPONSE_INIT_LINE);

        for (Rank rank : Rank.values()) {
            System.out.format(RESPONSE_MATCH_MESSAGE, rank.getMatchCount(), rank.getWinningMoney(), 0);
        }
        System.out.format(RESPONSE_TOTAL_EARNING_RATE_MESSAGE, 0);
    }

}

