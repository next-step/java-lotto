package step4.domain.winning;

public final class WinningStatus {

    private final int countOfMatch;
    private final boolean matchBonus;

    private WinningStatus(int countOfMatch, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static final WinningStatus from(int countOfMatch, boolean matchBonus) {
        return new WinningStatus(countOfMatch, matchBonus);
    }

}
