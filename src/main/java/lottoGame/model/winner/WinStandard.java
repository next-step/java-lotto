package lottoGame.model.winner;

import java.util.Arrays;

public enum WinStandard {
    FIRST("6개 일치 (2000000000원)-", 6, 2000000000),
    SECOND("5개 일치 (1500000원)-", 5, 1500000),
    THIRD("4개 일치 (50000원)-", 4, 50000),
    FOURTH("3개 일치 (5000원)-", 3, 5000),

    NOTHING("x", -1, 0),
    ;

    private final String desc;
    private final int value;
    private final int returnOfWin;

    WinStandard(String desc, int value, int returnOfWin) {
        this.desc = desc;
        this.value = value;
        this.returnOfWin = returnOfWin;
    }

    public static WinStandard findByValue(int value) {
        return Arrays.stream(WinStandard.values())
                .filter(winStandard -> winStandard.value == value)
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
}
