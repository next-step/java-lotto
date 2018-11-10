package lotto.enums;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.function.Function;

public enum MatchType {

    THREE(3, 5_000, 0),
    FOUR(4, 50_000, 0),
    FIVE(5, 150_000, 0),
    SIX(6, 2_000_000_000, 0),
    DEFAULT(0, 0, 0);

    private int match;
    private int price;
    private int count;

    MatchType(int match, int price, int count) {
        this.match = match;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public int getAmount() {
        return this.count * this.price;
    }

    public static int getTotalAmount() {
        return Arrays.stream(MatchType.values())
                .mapToInt(MatchType::getAmount)
                .sum();
    }

    public static int updateCount(int num) {
        if(THREE.match == num) {
            return THREE.count++;
        }

        if(FOUR.match == num) {
            return FOUR.count++;
        }

        if(FIVE.match == num) {
            return FIVE.count++;
        }

        if(SIX.match == num) {
            return SIX.count++;
        }

        return DEFAULT.count++;
    }
}
