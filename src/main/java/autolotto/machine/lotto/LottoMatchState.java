package autolotto.machine.lotto;

public class LottoMatchState {
    private final int matchCount;
    private final boolean hasBonusBall;

    public LottoMatchState(int matchCount, boolean hasBonusBall) {
        this.matchCount = matchCount;
        this.hasBonusBall = hasBonusBall;
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }
}
