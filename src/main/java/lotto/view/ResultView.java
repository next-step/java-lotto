package lotto.view;

import lotto.domain.LottoGroup;
import lotto.domain.LottoGroupResult;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계";
    private static final String SPLIT_LINE_MESSAGE = "---------";
    private static final String CORRECT_STATISTIC_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String EARNINGS_RATIO_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";
    private static final String ADVANTAGE_MESSAGE = "이익";
    private static final String DISADVANTAGE_MESSAGE = "손해";
    private static final String EVEN_MESSAGE = "본전";
    private static final Map<Integer, String> ADVANTAGE_STATUS = Map.of(
            1, ADVANTAGE_MESSAGE,
            0, EVEN_MESSAGE,
            -1, DISADVANTAGE_MESSAGE
    );

    private ResultView() {
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public static void printLottoGroup(LottoGroup lottoGroup) {
        for (List<Integer> lottoNumbers : lottoGroup.getLottoGroupNumber()) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printWinningStatistic(LottoGroupResult lottoGroupResult, int totalPrice) {
        System.out.println();
        System.out.println(WINNING_STATISTIC_MESSAGE);
        System.out.println(SPLIT_LINE_MESSAGE);
        Stream.of(LottoRank.values()).filter(lottoRank -> !lottoRank.equals(LottoRank.MISS)).forEach(lottoRank -> System.out.println(String.format(
                CORRECT_STATISTIC_MESSAGE,
                lottoRank.matchCount(),
                lottoRank.winningMoney(),
                lottoGroupResult.getLottoMatchCount(lottoRank)
        )));
        Double earningRatio = lottoGroupResult.getEarningRatio(totalPrice);
        System.out.println(String.format(EARNINGS_RATIO_MESSAGE, earningRatio, ADVANTAGE_STATUS.get(earningRatio.compareTo(1.00))));
    }
}
