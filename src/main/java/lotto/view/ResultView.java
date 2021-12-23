package lotto.view;

import lotto.domain.PrizeType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultView {
    private BigDecimal profit = BigDecimal.ZERO;

    public ResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printPrize(PrizeType prizeType, int matchCount) {
        String bonusBallString = " ";
        if (prizeType == PrizeType.SECOND) {
            bonusBallString = ", 보너스 볼 일치";
        }
        int prizeMoney = prizeType.getPrizeMoney();
        System.out.println(prizeType.getCountOfMatch() + "개 일치" + bonusBallString + "(" + prizeMoney + "원) - " + matchCount + "개");
        profit = profit.add(new BigDecimal(prizeMoney).multiply(new BigDecimal(matchCount)));
    }

    public void printProfitMargin(BigDecimal investment) {
        BigDecimal margin = this.profit.divide(investment, 3, RoundingMode.HALF_UP);
        String result = margin.compareTo(BigDecimal.ONE) > 0 ? "이익" : "손해";
        System.out.println("총 수익률은 " + margin + "입니다.(기준이 1이기 때문에 결과적으로 " + result + "라는 의미임)");
    }

}
