package step2.domain.type;

public enum Bonus {

    NOT_USE(false, false),
    USE_AND_NOT_MATCHED(true, false),
    USE_AND_MATCHED(true, true);

    private boolean useBonusMatch;
    private boolean isBonusMatched;

    Bonus(boolean useBonusMatch, boolean isBonusMatched) {
        this.useBonusMatch = useBonusMatch;
        this.isBonusMatched = isBonusMatched;
    }

    public boolean equalBonus(boolean isBonusMatched) {
        return notUseBonus() || isMatched(isBonusMatched);
    }

    private boolean notUseBonus() {
        return !this.useBonusMatch;
    }

    private boolean isMatched(boolean isBonusMatched) {
        return this.useBonusMatch && this.isBonusMatched == isBonusMatched;
    }

    public boolean useBonusAndMatched() {
        return this.useBonusMatch && this.isBonusMatched;
    }

}
