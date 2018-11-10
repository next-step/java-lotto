package lotto.enums;

import java.util.function.Function;

public enum MatchType {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 150_000),
    SIX(6, 2_000_000_000),
    DEFAULT(0, 0);

    private int match;
    private int price;

    MatchType(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static int getMatchedPrice(int num) {
        if(MatchType.THREE.match == num) {
            return MatchType.THREE.price;
        }

        if(MatchType.FOUR.match == num) {
            return MatchType.FOUR.price;
        }

        if(MatchType.FIVE.match == num) {
            return MatchType.FIVE.price;
        }

        if(MatchType.SIX.match == num) {
            return MatchType.SIX.price;
        }

        return MatchType.DEFAULT.price;
    }

}
