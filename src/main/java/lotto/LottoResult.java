package lotto;

public class LottoResult {

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

        for (Prize prize : Prize.values()) {
            rate += prize.calculatePrizeMoney(matchCount);
        }
        rate /= money;
        return rate;
    }
}
