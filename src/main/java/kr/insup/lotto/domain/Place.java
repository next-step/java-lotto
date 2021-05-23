package kr.insup.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Place {
    First(6, 2000),
    Second(5, 150),
    Third(4, 50),
    Fourth(3, 5),
    None(0, 0);

    private final int match;
    private final int winnings;
    private static Map<Integer, Place> placeMap = new HashMap<>();

    static {
        for (Place place : values()) {
            placeMap.put(place.match, place);
        }
    }

    Place(int match, int winnings) {
        this.match = match;
        this.winnings = winnings;
    }

    public static Place matchPlace(int match) {
        if (placeMap.containsKey(match)) {
            return placeMap.get(match);
        }
        return None;
    }

    public int winnings() {
        return winnings;
    }

    public int match() {
        return match;
    }
}
