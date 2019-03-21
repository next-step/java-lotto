package lotto.domain;

public class MatchLotto {

    private static final int LOTTO_SIZE = 7;

    private int[] matchCounts;
    private int bonusCount;

    public MatchLotto() {
        this.matchCounts = new int[LOTTO_SIZE];
    }

    public MatchLotto(int[] matchCount, int bonusCount) {
        this.matchCounts = matchCount;
        this.bonusCount = bonusCount;
    }

    public void addMatchCount(int matchCount) {
        this.matchCounts[matchCount]++;
    }

    public int checkMatchCount(int matchCount) {
        return this.matchCounts[matchCount];
    }

    public long sumPrizeMoney() {
        long prizeMoney = 0;
        for (Prize prize : Prize.values()) {
            prizeMoney += prize.calculatePrizeMoney(this.matchCounts, prize.name());
        }
        prizeMoney += Prize.calculateBonusMoney(this.bonusCount);

        return prizeMoney;
    }

    public void addBonusCount() {
        this.bonusCount++;
    }

    public int getBonusCount() {
        return this.bonusCount;
    }

    public int[] getMatchCounts() {
        return this.matchCounts;
    }


}
