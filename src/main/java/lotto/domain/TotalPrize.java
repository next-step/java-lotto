package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TotalPrize {
    private final List<Prize> totalPrize;

    public TotalPrize(int totalPrize) {
        this(Collections.singletonList(new Prize(totalPrize)));
    }

    public TotalPrize(List<Prize> totalPrize) {
        this.totalPrize = totalPrize;
    }

    public static TotalPrize from(List<Integer> totalPrize) {
        return new TotalPrize(totalPrize.stream()
                .map(Prize::new)
                .collect(Collectors.toList()));
    }

    public double dividedBy(PurchaseAmount purchaeAmount) {
        return purchaeAmount.divide(this.sum());
    }

    protected int sum() {
        return totalPrize.stream()
                .mapToInt(Prize::prize)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalPrize that = (TotalPrize) o;
        return Objects.equals(totalPrize, that.totalPrize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrize);
    }
}
