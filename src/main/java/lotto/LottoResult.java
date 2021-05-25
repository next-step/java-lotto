package lotto;

public class LottoResult {
    private static final int FRIST_REWORD = 2000000000;
    private static final int SECOND_REWORD = 1500000;
    private static final int THIRD_REWORD = 50000;
    private static final int FOURTH_REWORD = 5000;

    private int countFristLotto = 0;
    private int countSecondLotto = 0;
    private int countThirdLotto = 0;
    private int countFourthLotto = 0;
    private int rewardSum = 0;
    private long profit = 0L;

    public int getCountFristLotto() {
        return countFristLotto;
    }

    public int getCountSecondLotto() {
        return countSecondLotto;
    }

    public int getCountThirdLotto() {
        return countThirdLotto;
    }

    public int getCountFourthLotto() {
        return countFourthLotto;
    }

    public long getProfit() {
        return profit;
    }

    public boolean isFirst(int expectedCount) {
        return this.countFristLotto == expectedCount;
    }
    public boolean isSecond(int expectedCount) {
        return this.countSecondLotto == expectedCount;
    }
    public boolean isThird(int expectedCount) {
        return this.countThirdLotto == expectedCount;
    }

    public boolean isFourth(int expectedCount) {
        return this.countFourthLotto == expectedCount;
    }

    public void checkRank(int compareWinLottoNumber) {
        if (compareWinLottoNumber == 3) {
            countFourthLotto++;
            return;
        }
        if (compareWinLottoNumber == 4) {
            countThirdLotto++;
            return;
        }
        if (compareWinLottoNumber == 5) {
            countSecondLotto++;
            return;
        }
    }

    public void winLotto() {
        countFristLotto++;
    }

    public void calculateProfit(int lottoCount) {
        calculateReward();
        if(rewardSum == 0){
            profit = 0;
            return;
        }
        profit = rewardSum / (lottoCount * LottoValidationUtils.LOTTO_COST);
    }

    private void calculateReward() {
        rewardSum = ((FRIST_REWORD * countFristLotto) + (SECOND_REWORD * countSecondLotto) + (THIRD_REWORD * countThirdLotto)
                + (FOURTH_REWORD * countFourthLotto));
    }
}
