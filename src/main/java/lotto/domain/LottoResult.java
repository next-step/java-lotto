package lotto.domain;

public enum LottoResult {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int sameNumberCount;
    private final int winnings;
    private int count;

    LottoResult(int sameNumberCount, int winnings) {
        this.sameNumberCount = sameNumberCount;
        this.winnings = winnings;
    }

    public int getCount() {
        return count;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public void addCount(int sameNumberCount){
        if(this.sameNumberCount == sameNumberCount){
            count++;
        }
    }
}
