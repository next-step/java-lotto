package lotto.view;

import lotto.domain.Lottos;

import java.text.DecimalFormat;

public class ResultView {
    private final int LOTTO_MIN_MATCH_COUNT = 3;
    private final int LOTTO_MAX_MATCH_COUNT = 6;

    public void printLottoResult(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void printLottoStatistics(Lottos lottoResult, int lottoAmount) {
        printLottoStatisticsStart();
        printLottoMatchCountStatistics(lottoResult);
        printLottoRateOfReturn(lottoResult, lottoAmount);
    }

    private void printLottoMatchCountStatistics(Lottos lottos) {
        for (int matchCount = LOTTO_MIN_MATCH_COUNT; matchCount <= LOTTO_MAX_MATCH_COUNT; matchCount++) {
            int count = lottos.getCountByMatchCount(matchCount);
            int prizeMoney = lottos.getPrizeMoneyByMatchCount(matchCount);
            System.out.println(matchCount + "개 일치 " + "(" + prizeMoney + "원)- " + count + "개");
        }
    }

    private void printLottoStatisticsStart() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printLottoRateOfReturn(Lottos lottos, double purchasingAmount) {
        double totalEarnings = calculateTotalEarnings(lottos);
        double returnRate = calculateReturnRate(totalEarnings, purchasingAmount);
        printFormattedReturnRate(returnRate);
    }

    private double calculateTotalEarnings(Lottos lottos) {
        double totalEarnings = 0;
        for (int matchCount = LOTTO_MIN_MATCH_COUNT; matchCount <= LOTTO_MAX_MATCH_COUNT; matchCount++) {
            totalEarnings += lottos.getEarningsByMatchCount(matchCount);
        }
        return totalEarnings;
    }

    private double calculateReturnRate(double totalEarnings, double purchasingAmount) {
        if (purchasingAmount == 0) {
            throw new IllegalArgumentException("구매 금액은 0이 될 수 없습니다.");
        }
        return totalEarnings / purchasingAmount;
    }

    private void printFormattedReturnRate(double returnRate) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("총 수익률은 " + df.format(returnRate) + "입니다.");
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
