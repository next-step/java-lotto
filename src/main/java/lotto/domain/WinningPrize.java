package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningPrize {

    THREE(3, BigDecimal.valueOf(5000), true),
    FOR(4, BigDecimal.valueOf(50000), true),
    FIVE(5, BigDecimal.valueOf(1500000), true),
    SIX(6, BigDecimal.valueOf(2000000000), true),
    MISS(0, BigDecimal.valueOf(0), false);

    private final int countOfMatch;
    private final BigDecimal price;
    private boolean print;

    WinningPrize(final int countOfMatch, final BigDecimal price, final boolean print) {

        this.countOfMatch = countOfMatch;
        this.price = price;
        this.print = print;
    }

    public static WinningPrize from(final int matchNumber) {

        return Arrays.stream(WinningPrize.values())
                .filter(oper -> oper.getCountOfMatch() == matchNumber)
                .findFirst()
                .orElse(WinningPrize.MISS);
    }

    public static Map<Integer, BigDecimal> init() {

        return Collections.unmodifiableMap(Stream.of(values())
                .filter(value -> value.print)
                .collect(Collectors.toMap(WinningPrize::getCountOfMatch, WinningPrize::getPrice)));
    }

    public int getCountOfMatch() {

        return countOfMatch;
    }

    public BigDecimal getPrice() {

        return price;
    }
}
