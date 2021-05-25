package lotto.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lotto.exceptions.NumberOutOfBoundsException;

public enum Prize {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    BONUS(7, 30_000_000);

    private static final int MIN_INDEX = 0;
    private static final int MAX_INDEX = 7;

    private static final Map<Integer, Prize> lookup = new HashMap<>();

    static {
        Arrays.stream(Prize.values())
            .forEach(prize -> lookup.put(prize.index, prize));
    }

    private int index;
    private int prize;

    Prize(int index, int prize) {
        this.index = index;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getIndex() {
        return this.index;
    }

    public static Prize valueOf(int index) {
        if (index < MIN_INDEX || MAX_INDEX < index) {
            throw new NumberOutOfBoundsException(ErrorMessage.PRIZE_OUT_OF_BOUNDS.toString());
        }
        return lookup.get(index);
    }
}
