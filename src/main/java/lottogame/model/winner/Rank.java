package lottogame.model.winner;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST("1등", 6, false, 2_000_000_000),
    SECOND("2등", 5, true, 30_000_000),
    THIRD("3등", 5, false, 1_500_000),
    FOURTH("4등", 4, false, 50_000),
    FIFTH("5등", 3, false, 5_000),

    NOTHING("x", -1, false,0),
    ;

    private final String desc;
    private final int value;
    private final boolean isBonus;
    private final int returnOfWin;

    Rank(String desc, int value, boolean isBonus, int returnOfWin) {
        this.desc = desc;
        this.value = value;
        this.isBonus = isBonus;
        this.returnOfWin = returnOfWin;
    }

    public static Rank findBy(int value, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(winStandard -> winStandard.value == value)
                .filter(winStandard -> winStandard.isBonus == isBonus)
                .findFirst().orElse(NOTHING);
    }

    public boolean isNothing() {
        return this == NOTHING;
    }

    public static Map<Rank, Integer> getInitWinStandardMap() {
        return Arrays.stream(Rank.values())
                .filter(winStandard -> !winStandard.isNothing())
                .collect(Collectors.toMap(
                        winStandard -> winStandard,
                        winStandard -> 0
                ));
    }

    public int value() {
        return this.value;
    }

    public int calculateWinReturn(int winCount) {
        return this.returnOfWin * winCount;
    }
}
