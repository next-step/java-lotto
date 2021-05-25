package autolotto;

import java.math.BigDecimal;

public class WinStatistics {
    private int threeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int sixMatch = 0;
    private int totalCount = 0;

    private final static int THREE_MATCH_PROFIT = 5000;
    private final static int FOUR_MATCH_PROFIT = 50000;
    private final static int FIVE_MATCH_PROFIT = 1500000;
    private final static int SIX_MATCH_PROFIT = 2000000000;


    private final static String THREE_MATCH_WORDING = "3개 일치 (5000원)- %s개";
    private final static String FOUR_MATCH_WORDING = "4개 일치 (50000원)- %s개";
    private final static String FIVE_MATCH_WORDING = "5개 일치 (1500000원)- %s개";
    private final static String SIX_MATCH_WORDING = "6개 일치 (2000000000원)- %s개";
    private final static String TOTAL_MATCH_WORDING_LOSS = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private final static String TOTAL_MATCH_WORDING_PROFIT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)";

    public void collectWin(int num) {
        if (num == 3) {
            this.threeMatch++;
        }
        if (num == 4) {
            this.fourMatch++;
        }
        if (num == 5) {
            this.fiveMatch++;
        }
        if (num == 6) {
            this.sixMatch++;
        }
        totalCount++;
    }

    public String generateWinWords() {
        String output = String.format(THREE_MATCH_WORDING, this.threeMatch) + "\n";
        output += String.format(FOUR_MATCH_WORDING, this.fourMatch) + "\n";
        output += String.format(FIVE_MATCH_WORDING, this.fiveMatch) + "\n";
        output += String.format(SIX_MATCH_WORDING, this.sixMatch) + "\n";
        double totalProfitRatio = this.calculateTotalProfit();
        if (totalProfitRatio >= 1) {
            output += String.format(TOTAL_MATCH_WORDING_PROFIT, totalProfitRatio);
            return output;
        }
        output += String.format(TOTAL_MATCH_WORDING_LOSS, totalProfitRatio);
        return output;
    }

    private double calculateTotalProfit() {
        int totalProfit = (threeMatch * THREE_MATCH_PROFIT) + (fourMatch * FOUR_MATCH_PROFIT) + (fiveMatch * FIVE_MATCH_PROFIT) + (sixMatch * SIX_MATCH_PROFIT);
        BigDecimal divisor = new BigDecimal(totalCount * LottoUtil.LOTTO_PRICE);
        BigDecimal totalProfitRatio = new BigDecimal(totalProfit).divide(divisor, 2, BigDecimal.ROUND_HALF_DOWN);
        return totalProfitRatio.doubleValue();
    }

}
