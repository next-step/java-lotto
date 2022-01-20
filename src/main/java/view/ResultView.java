package view;

import domain.Prize;
import domain.Prizes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {
    private final static String MESSAGE_LOTTO_COUNT = "개를 구매했습니다";
    private final static String MESSAGE_STATISTIC = "당첨 통계";
    private final static String MESSAGE_STATISTIC_LINE = "---------";
    private final static String MESSAGE_PRIZE_IS = "개 일치 (";
    private final static String MESSAGE_PRIZE_WON = "원)- ";
    private final static String MESSAGE_MATCH_COUNT = "개";
    private final static String MESSAGE_RATIO_RESULT = "총 수익률은 ";
    private final static String MESSAGE_RATIO_RESULT_END = "입니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + MESSAGE_LOTTO_COUNT);
    }

    public void printAllLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printResultStatistic(Map<Integer, Integer> lottoResult) {
        System.out.println("\n" + MESSAGE_STATISTIC + "\n" + MESSAGE_STATISTIC_LINE);

        for (int matchCount = 3; matchCount <= 6; matchCount++) {
            System.out.println(matchCount + MESSAGE_PRIZE_IS
                    + Prize.prizes.getOrDefault(matchCount, 0) + MESSAGE_PRIZE_WON
                    + lottoResult.getOrDefault(matchCount, 0) + MESSAGE_MATCH_COUNT);
        }
    }

    public void printResultRatio(BigDecimal prizeRatio) {
        System.out.println(MESSAGE_RATIO_RESULT + prizeRatio + MESSAGE_RATIO_RESULT_END);
    }
}
