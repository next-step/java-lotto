package step2.view;

import step2.domain.LottoResult;

import java.text.DecimalFormat;

public class ResultView {
    private final int LOTTO_MIN_MATCH_COUNT = 3;
    private final int LOTTO_MAX_MATCH_COUNT = 6;

    public void printLottoResult(LottoResult lottoResult) {
        lottoResult.getLottoResults().stream().forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public void printLottoStatistics(LottoResult lottoResult, int lottoAmount) {
        printLottoStatisticsStart();
        printLottoMatchCountStatistics(lottoResult);
        printLottoRateOfReturn(lottoResult, lottoAmount);
    }

    private void printLottoMatchCountStatistics(LottoResult lottoResult) {
        for (int matchCount = LOTTO_MIN_MATCH_COUNT; matchCount <= LOTTO_MAX_MATCH_COUNT; matchCount++) {
            int count = lottoResult.getCountByMatchCount(matchCount);
            int prizeMoney = lottoResult.getPrizeMoneyByMatchCount(matchCount);
            System.out.println(matchCount + "개 일치 " + "(" + prizeMoney + "원)- " + count + "개");
        }
    }

    private void printLottoStatisticsStart() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printLottoRateOfReturn(LottoResult lottoResult, double purchasingAmount) {
        double totalEarnings = 0;
        for (int matchCount = LOTTO_MIN_MATCH_COUNT; matchCount < LOTTO_MAX_MATCH_COUNT; matchCount++) {
            totalEarnings += lottoResult.getEarningsByMatchCount(matchCount);
        }

        double returnRate = totalEarnings / purchasingAmount;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("총 수익률은 " + df.format(returnRate) + "입니다.");
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
