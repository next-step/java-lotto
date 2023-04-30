package lotto.domain;

public class Result {
    private int matched3NumbersCount;
    private int matched4NumbersCount;
    private int matched5NumbersCount;
    private int matched6NumbersCount;
    private int prizeAmount;


    public void update(MyLotto myLotto) {
        if (myLotto.matchingCount() == 3) {
            matched3NumbersCount++;
            return;
        }
        if (myLotto.matchingCount() == 4) {
            matched4NumbersCount++;
            return;
        }
        if (myLotto.matchingCount() == 5) {
            matched5NumbersCount++;
            return;
        }
        if (myLotto.matchingCount() == 6) {
            matched6NumbersCount++;
        }
    }

    public void sumPrizeAmount() {
        prizeAmount += matched3NumbersCount * LottoRule.MATCHED_3_NUMBERS_PRIZE;
        prizeAmount += matched4NumbersCount * LottoRule.MATCHED_4_NUMBERS_PRIZE;
        prizeAmount += matched5NumbersCount * LottoRule.MATCHED_5_NUMBERS_PRIZE;
        prizeAmount += matched6NumbersCount * LottoRule.MATCHED_6_NUMBERS_PRIZE;
    }

    public int getMatched3NumbersCount() {
        return matched3NumbersCount;
    }

    public int getMatched4NumbersCount() {
        return matched4NumbersCount;
    }

    public int getMatched5NumbersCount() {
        return matched5NumbersCount;
    }

    public int getMatched6NumbersCount() {
        return matched6NumbersCount;
    }

    public double profit(int money) {
        return (prizeAmount + 0.0) / money;
    }
}
