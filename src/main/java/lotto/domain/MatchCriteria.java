package lotto.domain;

public enum MatchCriteria {
    THREE(3, new Amount(5000), new Count(0)),
    FOUR(4, new Amount(50_000), new Count(0)),
    FIVE(5, new Amount(1_500_000), new Count(0)),
    SIX(6, new Amount(2_000_000_000), new Count(0));

    private final int criteria;
    private final Amount prize;
    private Count count;

    MatchCriteria(int criteria, Amount prize, Count count) {
        this.criteria = criteria;
        this.prize = prize;
        this.count = count;
    }

    public Amount calc() {
        return prize.multiflyCountAmount(count);
    }

    public MatchCriteria match() {
        count = count.increasedCount();
        return this;
    }

    public boolean equalsCriteria(int criteria) {
        return this.criteria == criteria;
    }

    public boolean equalsCount(Count count) {
        return this.count.equals(count);
    }

    public int getCount() {
        return this.count.getValue();
    }

    public int getCriteria() {
        return criteria;
    }

    public double getPrize() {
        return prize.getValue();
    }
}
