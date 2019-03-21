package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final Map<WinningOrder, Long> values;

    public WinningStatistics(final Map<WinningOrder, Long> values) {
        this.values = initialize();
        this.values.putAll(values);
    }

    public Map<WinningOrder, Long> get() {
        return new HashMap<>(values);
    }

    public double getRoi() {
        return BigDecimal.valueOf(getTotalAmount())
                .divide(getDivisor(), 2, RoundingMode.FLOOR)
                .doubleValue()
                ;
    }

    private Map<WinningOrder, Long> initialize() {
        return Arrays.stream(WinningOrder.values())
                .collect(Collectors.toMap(Function.identity(), l -> 0L))
                ;
    }

    private long getTotalAmount() {
        return this.values
                .entrySet()
                .stream()
                .mapToLong(value -> value.getKey().getAmount() * value.getValue())
                .sum()
                ;
    }

    private BigDecimal getDivisor() {
        final BigDecimal amount = BigDecimal.valueOf(getCount())
                .multiply(BigDecimal.valueOf(Lotto.PRICE))
                ;
        if (BigDecimal.ZERO.equals(amount)) {
            return BigDecimal.ONE;
        }
        return amount;
    }

    private long getCount() {
        return this.values
                .values()
                .stream()
                .mapToLong(Long::valueOf)
                .sum()
                ;
    }
}
