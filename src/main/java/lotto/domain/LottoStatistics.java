package lotto.domain;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;

    private double profit;

    private int firstCnt;
    private int secondCnt;
    private int thirdCnt;
    private int forthCnt;

    public void incrPrizeCnt(LottoPrize prize) {
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
        profit = (LottoPrize.FORTH.getPrize() * forthCnt + LottoPrize.THIRD.getPrize() * thirdCnt + LottoPrize.SECOND.getPrize() * secondCnt + LottoPrize.FIRST.getPrize() * firstCnt)/(buyCount*LOTTO_PRICE*1.0d);
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
