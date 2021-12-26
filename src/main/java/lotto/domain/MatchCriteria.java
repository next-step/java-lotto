package lotto.domain;

public enum MatchCriteria {
    THREE(new Criteria(3), new Amount(5_000), new Count(0)),
    FOUR(new Criteria(4), new Amount(50_000), new Count(0)),
    FIVE(new Criteria(5), new Amount(1_500_000), new Count(0)),
    SIX(new Criteria(6), new Amount(2_000_000_000), new Count(0));

    private final Criteria criteria;
    private final Amount prize;
    private Count count;

    MatchCriteria(Criteria criteria, Amount prize, Count count) {
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

    public boolean equalsCriteria(Criteria criteria) {
        return this.criteria.equals(criteria);
    }

    public boolean equalsCount(Count count) {
        return this.count.equals(count);
    }

    public int getCount() {
        return this.count.getValue();
    }

    public int getCriteria() {
        return this.criteria.getValue();
    }

    public double getPrize() {
        return prize.getValue();
    }
}
