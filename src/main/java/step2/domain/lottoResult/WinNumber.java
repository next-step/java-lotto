package step2.domain.lottoResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinNumber {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    LOSE(0, 0);

    private final int hit;
    private final int money;

    WinNumber(int hit, int money) {
        this.hit = hit;
        this.money = money;
    }

    public int getHit() {
        return hit;
    }

    public int getMoney() {
        return money;
    }

    public static WinNumber valueOf(int hit, boolean matchBonus) {
        if (hit == 5) {
            return matchBonus ? WinNumber.SECOND : WinNumber.THIRD;
        }

        return Arrays.stream(values())
                .filter(it -> it.getHit() == hit)
                .findFirst()
                .orElse(LOSE);
    }
}
