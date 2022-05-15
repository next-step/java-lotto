package lotto.view;

import lotto.domain.LottoGroup;
import lotto.domain.LottoGroupResult;
import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final double STANDARD_POINT = 1.00;
    private static final int ADVANTAGE_FLAG = 1;
    private static final int EVEN_FLAG = 0;
    private static final int DISADVANTAGE_FLAG = -1;
    private static final String LOTTO_COUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATISTIC_MESSAGE = "\n당첨 통계";
    private static final String SPLIT_LINE_MESSAGE = "---------";
    private static final String CORRECT_STATISTIC_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String CORRECT_SECOND_RANK_STATISTIC_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String EARNINGS_RATIO_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";
    private static final String ADVANTAGE_MESSAGE = "이익";
    private static final String DISADVANTAGE_MESSAGE = "손해";
    private static final String EVEN_MESSAGE = "본전";
    private static final Map<Integer, String> ADVANTAGE_STATUS = Map.of(
            ADVANTAGE_FLAG, ADVANTAGE_MESSAGE,
            EVEN_FLAG, EVEN_MESSAGE,
            DISADVANTAGE_FLAG, DISADVANTAGE_MESSAGE
    );

    private ResultView() {
    }

    public static void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, manualLottoCount, autoLottoCount));
    }

    public static void printLottoGroup(LottoGroup lottoGroup) {
        for (List<Integer> lottoNumbers : lottoGroup.getLottoGroupNumber()) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printWinningStatistic(LottoGroupResult lottoGroupResult, int totalPrice) {
        System.out.println(WINNING_STATISTIC_MESSAGE);
        System.out.println(SPLIT_LINE_MESSAGE);
        printLottoGroupResult(lottoGroupResult);
        Double earningRatio = lottoGroupResult.getEarningRatio(totalPrice);
        System.out.println(String.format(EARNINGS_RATIO_MESSAGE, earningRatio, ADVANTAGE_STATUS.get(earningRatio.compareTo(STANDARD_POINT))));
    }

    private static void printLottoGroupResult(LottoGroupResult lottoGroupResult) {
        Arrays.stream(LottoRank.values()).sorted(Comparator.reverseOrder()).filter(lottoRank -> !lottoRank.equals(LottoRank.MISS)).forEach(lottoRank -> System.out.println(String.format(
                getCorrectStatisticMessage(lottoRank),
                lottoRank.matchCount(),
                lottoRank.winningMoney(),
                lottoGroupResult.getLottoMatchCount(lottoRank)
        )));
    }

    private static String getCorrectStatisticMessage(LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND)) {
            return CORRECT_SECOND_RANK_STATISTIC_MESSAGE;
        }
        return CORRECT_STATISTIC_MESSAGE;
    }
}
