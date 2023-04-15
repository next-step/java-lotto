package lotto.constant;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSE(-1, 0, false)

    ;
// !matchBonus ||
    private int matchCount;
    private int prize;
    private boolean matchBonus;

    LottoRank(int matchCount, int prize, boolean matchBonus) {
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

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public static LottoRank getRank(int matchCount, boolean containsBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(o ->
                        matchCount == o.getMatchCount()
                        && (!o.getMatchBonus() || containsBonusBall == o.getMatchBonus()))
                .findAny()
                .orElse(LottoRank.LOSE);
    }

    public String toString(int count) {
        String strFormat = "%d개 일치 (%d 원)- %d개";
        if (this == SECOND) {
            strFormat = "%d개 일치, 보너스 볼 일치(%d 원)- %d개";
        }
        return String.format(strFormat, this.matchCount, this.prize, count);
    }
}
