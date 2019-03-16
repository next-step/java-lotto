package lotto.domain;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;

    private double profit;

    private int firstCnt;
    private int secondCnt;
    private int thirdCnt;
    private int forthCnt;

    public enum Prize {
        FIRST(6, 2000000000),
        SECOND(5, 1500000),
        THIRD(4, 50000),
        FORTH(3, 5000),
        FIFTH(2, 0),
        SIXTH(1, 0),
        SEVENTH(1, 0),
        EIGHTH(0, 0);

        private int matchCount;
        private int prize;

        Prize(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public static Prize getEnumNameByIntValue(int matchCount){
            Prize result = null;

            for(Prize prize : Prize.values()){
                if (prize.matchCount == matchCount) {
                    result = prize;
                    break;
                }
            }

            return result;
        }
    }

    public void incrPrizeCnt(Prize prize) {
        switch (prize) {
            case FIRST:
                firstCnt++;
                break;
            case SECOND:
                secondCnt++;
                break;
            case THIRD:
                thirdCnt++;
                break;
            case FORTH:
                forthCnt++;
                break;
            default:
                break;
        }
    }

    public double calculateProfit(int buyCount) {
        profit = (Prize.FORTH.prize * forthCnt + Prize.THIRD.prize * thirdCnt + Prize.SECOND.prize * secondCnt + Prize.FIRST.prize * firstCnt)/(buyCount*LOTTO_PRICE*1.0d);
        return profit;
    }

    public double getProfit() {
        return profit;
    }

    public int getFirstCnt() {
        return firstCnt;
    }

    public int getSecondCnt() {
        return secondCnt;
    }

    public int getThirdCnt() {
        return thirdCnt;
    }

    public int getForthCnt() {
        return forthCnt;
    }
}
