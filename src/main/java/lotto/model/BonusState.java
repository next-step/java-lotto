package lotto.model;

public enum BonusState {
    HIT,
    MISS,
    NO_MATTER;

    public boolean isHit() {
        return this == HIT;
    }

    private boolean isMiss() {
        return this == MISS;
    }

    private boolean isNoMatter() {
        return this == NO_MATTER;
    }

    public boolean match(boolean correctBonus) {
        return isNoMatter() || (isHit() && correctBonus) || (isMiss() && !correctBonus);
    }
}
