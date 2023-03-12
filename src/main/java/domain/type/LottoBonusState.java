package domain.type;

public enum LottoBonusState {
    YES(true),
    NO(false),
    ANY(false);

    private boolean bonusYn;

    private LottoBonusState(boolean bool) {
        this.bonusYn = bool;
    }

    public boolean getValue() {
        return this.bonusYn;
    }
}
