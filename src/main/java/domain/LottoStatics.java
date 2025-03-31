package domain;

import java.util.List;

public class LottoStatics {
    private int hit3Count = 0;
    private int hit4Count = 0;
    private int hit5Count = 0;
    private int hit6Count = 0;
    private int totalLottoCount = 0;
    private double profitRate;

    public static final int HIT_3_WINNING_AMOUNT = 5000;
    public static final int HIT_4_WINNING_AMOUNT = 50000;
    public static final int HIT_5_WINNING_AMOUNT = 150000;
    public static final int HIT_6_WINNING_AMOUNT = 2000000000;
    public static final int PROFIT_STANDARD = 1;

    public LottoStatics(List<Lotto> lottoList, List<Integer> winningNums) {
        this.totalLottoCount = lottoList.size();
        this.makeStatics(lottoList, winningNums);
        this.makeProfitRate();
    }

    public int getHit3Count() {
        return hit3Count;
    }

    public int getHit4Count() {
        return hit4Count;
    }

    public int getHit5Count() {
        return hit5Count;
    }

    public int getHit6Count() {
        return hit6Count;
    }

    private void makeStatics(List<Lotto> lottoList, List<Integer> winningNums) {
        for (Lotto lotto : lottoList) {
            int matchCount = (int) lotto.getNumList().stream()
                .filter(winningNums::contains)
                .count();

            this.increaseHitCount(matchCount);
        }
    }


    private void increaseHitCount(int matchCount) {
        switch (matchCount) {
            case 3:
                hit3Count++;
                break;
            case 4:
                hit4Count++;
                break;
            case 5:
                hit5Count++;
                break;
            case 6:
                hit6Count++;
                break;
        }
    }

    private void makeProfitRate() {
        int totalPrize = (hit3Count * HIT_3_WINNING_AMOUNT)
            + (hit4Count * HIT_4_WINNING_AMOUNT)
            + (hit5Count * HIT_5_WINNING_AMOUNT)
            + (hit6Count * HIT_6_WINNING_AMOUNT);

        int totalSpent = totalLottoCount * Lotto.PRICE_PER_ONE;
        this.profitRate = (double) totalPrize / totalSpent;
    }

    public String getProfitRate() {
        double truncatedRate = Math.floor(this.profitRate * 100) / 100.0;
        return String.format("%.2f", truncatedRate);
    }

    public boolean isProfit() {
        return this.profitRate > PROFIT_STANDARD;
    }
}
