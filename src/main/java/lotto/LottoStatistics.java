package lotto;

import java.math.BigDecimal;

import static lotto.Lotto.LOTTO_PRICE;


public class LottoStatistics {
    static public int getLottoBuyingCount(int money) {
        return Math.round(money / LOTTO_PRICE);
    }

    enum WinProfit {
        THREE_MATCH_PROFIT(5000),
        FOUR_MATCH_PROFIT(50000),
        FIVE_MATCH_PROFIT(1500000),
        SIX_MATCH_PROFIT(2000000000);

        private final int value;

        WinProfit(int value) {
            this.value = value;
        }
    }

    private int threeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int sixMatch = 0;
    private int totalCount = 0;

    public int threeMatch() {
        return threeMatch;
    }

    public int fourMatch() {
        return fourMatch;
    }

    public int fiveMatch() {
        return fiveMatch;
    }

    public int sixMatch() {
        return sixMatch;
    }

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

    public double calculateTotalProfit() {
        int totalProfit = (threeMatch * WinProfit.THREE_MATCH_PROFIT.value) + (fourMatch * WinProfit.FOUR_MATCH_PROFIT.value) + (fiveMatch * WinProfit.FIVE_MATCH_PROFIT.value) + (sixMatch * WinProfit.SIX_MATCH_PROFIT.value);
        BigDecimal divisor = new BigDecimal(totalCount * LOTTO_PRICE);
        BigDecimal totalProfitRatio = new BigDecimal(totalProfit).divide(divisor, 2, BigDecimal.ROUND_HALF_DOWN);
        return totalProfitRatio.doubleValue();
    }

}
