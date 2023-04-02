package lotto.constant;

public enum LottoRank {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    LOSE(-1, 0, false)
    ;

    private int matchCount;
    private int prize;
    private boolean matchBonus;

    private LottoRank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String toString(int count) {
        String strFormat = "%d개 일치 (%d원)- %d개";
        if (this == SECOND) {
            strFormat = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
        }
        return String.format(strFormat, this.matchBonus, this.prize, count);
    }
}
