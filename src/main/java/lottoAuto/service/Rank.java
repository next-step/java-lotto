package lottoAuto.service;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FORTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NO_MATCH(0, 0, false);

    private int matchWinning;
    private int prize;
    private boolean matchBonus;

    Rank(int matchWinning, int prize, boolean matchBonus) {
        this.matchWinning = matchWinning;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static Rank findByRank(int winning_count, Boolean bonus_count) {
        if (winning_count == 5 && bonus_count) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchWinning == winning_count && !rank.matchBonus)
                .findAny()
                .orElse(NO_MATCH);
    }

}
