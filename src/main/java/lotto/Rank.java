package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchCnt;
    private int winnnerPrice;

    Rank(int matchCnt, int winnnerPrice) {
        this.matchCnt = matchCnt;
        this.winnnerPrice = winnnerPrice;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getWinnnerPrice() {
        return winnnerPrice;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // 일치하는 수를 로또 등수로 변경한다.
        Rank rank = Arrays.stream(Rank.values())
                .filter(r -> r.getMatchCnt() == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
        if (isSecondPriceMatch(rank) && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }

    private static boolean isSecondPriceMatch(Rank rank){
        return rank.equals(Rank.SECOND);
    }
}
