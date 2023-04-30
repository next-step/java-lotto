package lotto.domain;

public class MyLottoResult {
    private int result3matched;
    private int result4matched;
    private int result5matched;
    private int result6matched;
    private int prizeAmount;


    public void update(MyLotto myLotto) {
        if (myLotto.winNumberCount() == 3) {
            result3matched++;
        } else if (myLotto.winNumberCount() == 4) {
            result4matched++;
        } else if (myLotto.winNumberCount() == 5) {
            result5matched++;
        } else if (myLotto.winNumberCount() == 6) {
            result6matched++;
        }
    }

    public void sumPrizeAmount() {
        prizeAmount += result3matched * LottoRule.MATCHED_3_NUMBERS_PRIZE;
        prizeAmount += result4matched * LottoRule.MATCHED_4_NUMBERS_PRIZE;
        prizeAmount += result5matched * LottoRule.MATCHED_5_NUMBERS_PRIZE;
        prizeAmount += result6matched * LottoRule.MATCHED_6_NUMBERS_PRIZE;
    }

    public int prizeAmount() {
        return prizeAmount;
    }

    public int getResult3matched() {
        return result3matched;
    }

    public int getResult4matched() {
        return result4matched;
    }

    public int getResult5matched() {
        return result5matched;
    }

    public int getResult6matched() {
        return result6matched;
    }
}
