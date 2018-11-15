package lotto.dto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);


    private final int match;
    private final int won;


    Rank(int match, int won) {
        this.match = match;
        this.won = won;
    }

    public int getMatch() {
        return match;
    }

    public int getWon() {
        return won;
    }

    public static Rank valueOf(int match, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        Rank lEnum = Arrays.stream(Rank.values())
                .filter(e -> e.getMatch() == match)
                .findFirst()
                .orElse(MISS);
        if(!matchBonus && match == SECOND.match)
            return Rank.THIRD;
        return lEnum;
    }
}
