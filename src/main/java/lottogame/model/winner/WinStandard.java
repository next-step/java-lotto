package lottogame.model.winner;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum WinStandard {
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

    WinStandard(String desc, int value, boolean isBonus, int returnOfWin) {
        this.desc = desc;
        this.value = value;
        this.isBonus = isBonus;
        this.returnOfWin = returnOfWin;
    }

    public static WinStandard findBy(int value, boolean isBonus) {
        return Arrays.stream(WinStandard.values())
                .filter(winStandard -> winStandard.value == value)
                .filter(winStandard -> winStandard.isBonus == isBonus)
                .findFirst().orElse(NOTHING);
    }

    public boolean isNothing() {
        return this == NOTHING;
    }

    public String desc() {
        return this.desc;
    }

    public int returnOfWin() {
        return this.returnOfWin;
    }

    public static Map<WinStandard, Integer> getInitWinStandardMap() {
        return Arrays.stream(WinStandard.values())
                .filter(winStandard -> !winStandard.isNothing())
                .collect(Collectors.toMap(
                        winStandard -> winStandard,
                        winStandard -> 0
                ));
    }

    public int value() {
        return this.value;
    }
}
