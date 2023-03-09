package domain;

public enum LottoBonusState {
    YES(true),
    NO(false);

    private boolean bonusYn;

    private LottoBonusState(boolean bool) {
        this.bonusYn = bool;
    }

    public boolean getValue() {
        return this.bonusYn;
    }
}
