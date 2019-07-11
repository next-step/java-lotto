package lottogame.domain;

import java.util.*;

public enum LottoRankData {
    FORTH_WINNER(5_000, 3),
    THIRD_WINNER(50_000, 4),
    SECOND_WINNER(1_500_000, 5),
    BONUS_SECOND_WINNER(3_000_0000, 5),
    FIRST_WINNER(2_000_000_000, 6),
    NO_MATCH(0, 0);

    private int prize, match;

    LottoRankData(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }

    public static LottoRankData match(int matchCount, boolean matchBonus) {
        if (matchCount == BONUS_SECOND_WINNER.getMatch() && matchBonus) {
            return BONUS_SECOND_WINNER;
        }
        return Arrays.stream(values())
                .filter(value -> value.getMatch() == matchCount)
                .findAny()
                .orElse(LottoRankData.NO_MATCH);
    }
}



