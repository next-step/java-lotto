package lotto.domain;

public enum BonusRequiredType {
    NO_MATTER() {
        @Override
        boolean evaluate(boolean hasBonus) {
            return true;
        }
    },
    REQUIRED() {
        @Override
        boolean evaluate(boolean hasBonus) {
            return hasBonus;
        }
    },
    NOT_REQUIRED() {
        @Override
        boolean evaluate(boolean hasBonus) {
            return !hasBonus;
        }
    };

    abstract boolean evaluate(boolean hasBonus);
}
