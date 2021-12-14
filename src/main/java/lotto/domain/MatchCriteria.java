package lotto.domain;

import java.util.Arrays;

    public enum MatchCriteria {
    THREE(3, 5000, 0),
    FOUR(4, 50000, 0),
    FIVE(5, 1500000, 0),
    SIX(6, 2000000000, 0),
    NOTING(0, 0, 0);

    private int criteria;
    private int prize;
    private int count = 0;

    MatchCriteria(int criteria, int prize, int count) {
        this.criteria = criteria;
        this.prize = prize;
        this.count = count;
    }

    public double calc() {
        return prize * count;
    }

    public MatchCriteria match() {
        count++;
        return this;
    }

    public MatchCriteria matchCriteria(int criteria) {
        return Arrays.stream(MatchCriteria.values())
                .filter(m -> m.equalsCriteria(criteria))
                .findFirst()
                .orElse(NOTING);
    }

    public boolean equalsCriteria(int criteria) {
        return this.criteria == criteria;
    }

    public boolean equalsCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return this.count;
    }

        public int getCriteria() {
            return criteria;
        }

        public int getPrize() {
            return prize;
        }
    }
