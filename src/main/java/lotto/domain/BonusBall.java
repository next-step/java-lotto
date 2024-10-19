package lotto.domain;

public class BonusBall {
    private final boolean matched;

    public BonusBall(boolean matched) {
        this.matched = matched;
    }

    public boolean isMatched() {
        return matched;
    }

}
