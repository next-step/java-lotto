package lotto.domain;

public class MatchResult {
    private final int count;
    private final boolean isBonus;

    public MatchResult(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }
    public int getCount() {
        return count;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}
