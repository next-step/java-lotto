package lotto.domain;

public enum BonusCondition {

    ANY,
    MUST_MATCH,
    MUST_NOT_MATCH;

    public boolean match(boolean matchedBonus) {
        if (this == MUST_MATCH) {
            return matchedBonus;
        }
        if (this == MUST_NOT_MATCH) {
            return !matchedBonus;
        }
        return true;
    }
}
