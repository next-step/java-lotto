package lotto.enums;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
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

    public int getMatch() {
        return this.match;
    }

    public static int getPrice(int num) {
        if(THREE.match == num) {
            return THREE.price;
        }

        if(FOUR.match == num) {
            return FOUR.price;
        }

        if(FIVE.match == num) {
            return FIVE.price;
        }

        if(SIX.match == num) {
            return SIX.price;
        }

        return DEFAULT.price;
    }
}
