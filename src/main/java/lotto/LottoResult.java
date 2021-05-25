package lotto;

public class LottoResult {
    private static final int FIRST_REWORD = 2000000000;
    private static final int SECOND_REWORD = 1500000;
    private static final int THIRD_REWORD = 50000;
    private static final int FOURTH_REWORD = 5000;

    private static final int FIRST_COLLECT_COUNT = 6;
    private static final int SECOND_COLLECT_COUNT = 5;
    private static final int THIRD_COLLECT_COUNT = 4;
    private static final int FOURTH_COLLECT_COUNT = 3;

    private static final String RESULT_FORM = "%d개 일치 (%d원)- %d개\n";
    private static final String REMARK = "총 수익률은 %.3f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private int countFirstLotto = 0;
    private int countSecondLotto = 0;
    private int countThirdLotto = 0;
    private int countFourthLotto = 0;
    private int rewardSum = 0;
    private double profit = 0;

    public int getCountFirstLotto() {
        return countFirstLotto;
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

    public double getProfit() {
        return profit;
    }

    public boolean isFirst(int expectedCount) {
        return this.countFirstLotto == expectedCount;
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
        if (compareWinLottoNumber == FOURTH_COLLECT_COUNT) {
            countFourthLotto++;
            return;
        }
        if (compareWinLottoNumber == THIRD_COLLECT_COUNT) {
            countThirdLotto++;
            return;
        }
        if (compareWinLottoNumber == SECOND_COLLECT_COUNT) {
            countSecondLotto++;
            return;
        }
    }

    public void winLotto() {
        countFirstLotto++;
    }

    public double calculateProfit(int lottoCount) {
        calculateReward();
        if(rewardSum == 0){
            profit = 0;
            return 0;
        }
        profit = Math.floor((double) rewardSum / (lottoCount * LottoValidationUtils.LOTTO_COST) * 100 ) / 100;
        return profit;
    }

    private void calculateReward() {
        rewardSum = ((FIRST_REWORD * countFirstLotto) + (SECOND_REWORD * countSecondLotto) + (THIRD_REWORD * countThirdLotto)
                + (FOURTH_REWORD * countFourthLotto));
    }

    public void printResult() {
        System.out.printf(RESULT_FORM, FIRST_COLLECT_COUNT, FIRST_REWORD, countFirstLotto);
        System.out.printf(RESULT_FORM, SECOND_COLLECT_COUNT, SECOND_REWORD, countSecondLotto);
        System.out.printf(RESULT_FORM, THIRD_COLLECT_COUNT, THIRD_REWORD, countThirdLotto);
        System.out.printf(RESULT_FORM, FOURTH_COLLECT_COUNT, FOURTH_REWORD, countFourthLotto);
        System.out.printf(REMARK, profit);

    }
}
