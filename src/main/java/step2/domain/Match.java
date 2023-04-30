package step2.domain;

public class Match {

    private final int count;
    private final boolean isBonus;

    public Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public boolean isEqual(int count, boolean isBonus) {
        return this.count == count && this.isBonus == isBonus;
    }
}


