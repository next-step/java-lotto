package lotto.domain;

public enum LottoMatchInformation {
    THREE(3, 0, 5000),
    FOUR(4, 0,50000),
    FIVE(5, 0,1500000),
    SIX(6, 0,2000000000);

    private final int match;
    private int count;
    private final double prize;

    LottoMatchInformation(int match, int count, double prize) {
        this.match = match;
        this.count = count;
        this.prize = prize;
    }

    public int getMatch() {
        return this.match;
    }

    public int getCount() {
        return count;
    }

    public double getPrize() {
        return prize;
    }

    public void addCount() {
        count++;
    }

    public double calculatePrize() {
        return count * prize;
    }
}
