package lottery.domain;

import java.util.Arrays;
import java.util.Optional;

public enum WinningType {
    LOSE  (0,  null,             0),
    FIFTH (3,  null,         5_000),
    FOURTH(4,  null,        50_000),
    THIRD (5, false,     1_500_000),
    SECOND(5,  true,     1_500_000),
    FIRST (6,  null, 2_000_000_000);

    private final int matches;
    private final Optional<Boolean> hasBonus;
    private final int earning;

    public static WinningType valueOf(int matches, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(value -> value.matches == matches)
                .filter(value -> value.hasBonus.orElse(hasBonus) == hasBonus)
                .findAny()
                .orElse(LOSE);
    }

    WinningType(int matches, Boolean hasBonus, int earning) {
        this.matches = matches;
        this.hasBonus = Optional.ofNullable(hasBonus);
        this.earning = earning;
    }

    public int getMatches() {
        return matches;
    }

    public boolean hasBonus() {
        return hasBonus.orElse(false);
    }

    public int getEarning() {
        return earning;
    }
}
