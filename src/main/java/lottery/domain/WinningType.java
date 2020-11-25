package lottery.domain;

public enum WinningType {
    FIFTH (3,         5_000),
    FOURTH(4,        50_000),
    THIRD (5,     1_500_000),
    FIRST (6, 2_000_000_000);

    private final int matches;
    private final int earning;

    WinningType(int matches, int earning) {
        this.matches = matches;
        this.earning = earning;
    }

    public int getMatches() {
        return matches;
    }

    public int getEarning() {
        return earning;
    }
}
