package lotto;

public class LottoResult {

    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 6;
    private static final int LOTTO_SIZE = 7;

    private int[] matchCount;

    public LottoResult() {
        matchCount = new int[LOTTO_SIZE];
    }

    public void addMatchCount(int i) {
        matchCount[i]++;
    }

    public int[] checkResult() {
        return matchCount;
    }

    public double calculateRate(int money) {
        double rate = 0;
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            rate += Prize.typeOf(i).calculatePrizeMoney(matchCount[i]);
        }
        rate /= money;
        return rate;
    }
}
