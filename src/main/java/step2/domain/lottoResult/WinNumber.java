package step2.domain.lottoResult;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinNumber {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int hit;
    private final int money;

    private static final Map<Integer, WinNumber> WinNumbers = Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(WinNumber::getHit, Function.identity())));

    WinNumber(int hit, int money) {
        this.hit = hit;
        this.money = money;
    }

    public static WinNumber win(int hit) {
        return WinNumbers.get(hit);
    }

    public int getHit() {
        return hit;
    }

    public int getMoney() {
        return money;
    }
}
