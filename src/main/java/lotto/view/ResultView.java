package lotto.view;

import java.math.BigDecimal;

public class ResultView {
    private BigDecimal profit = BigDecimal.ZERO;

    public ResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printPrize(int prizeCount, int prizeMoney, int matchCount) {
        System.out.println(prizeCount + "개 일치 (" + prizeMoney + "원) - " + matchCount + "개");
        profit = profit.add(new BigDecimal(prizeMoney).multiply(new BigDecimal(matchCount)));
    }

    public void printProfitMargin(BigDecimal investment) {
        BigDecimal margin = this.profit.divide(investment);
        String result = margin.compareTo(BigDecimal.ONE) > 0 ? "이익" : "손해";
        System.out.println("총 수익률은 " + margin + "입니다.(기준이 1이기 때문에 결과적으로 "+ result +"라는 의미임)");
    }

}
