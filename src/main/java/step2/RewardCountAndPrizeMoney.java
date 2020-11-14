package step2;

class RewardCountAndPrizeMoney {
    private final int count;
    private final int prizeMoney;

    public RewardCountAndPrizeMoney(final int count, final Money prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney.getValue();
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
