package step2.domain;

public class Match {

    private final int count;
    private final boolean isBonus;

    public Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    @Override
    public String toString() {
        return "Match{" +
                "count=" + count +
                ", isBonus=" + isBonus +
                '}';
    }
}


