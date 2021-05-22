package lotto;

import java.util.HashMap;

public enum MatchStatus {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ZERO(0,0);


    private int matchCount;
    private int price;

    public static final HashMap<Integer, MatchStatus> countMap = createCountMap();

    MatchStatus(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    static HashMap<Integer, MatchStatus> createCountMap() {
        HashMap<Integer, MatchStatus> map = new HashMap<>();
        for (MatchStatus status : values()) {
            map.put(status.matchCount, status);
        }
        return map;
    }

    static MatchStatus findStatusByMatchCount(int matchCount) {
         return countMap.get(matchCount);
    }
}
