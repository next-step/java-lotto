package study.lotto.domain;

import java.math.BigDecimal;

public class TotalPrize {
    private BigDecimal totalPrize;

    private TotalPrize(BigDecimal totalPrize) {
        this.totalPrize = totalPrize;
    }

    public TotalPrize() {
        this(BigDecimal.ZERO);
    }

    public void add(BigDecimal prize) {
        totalPrize = totalPrize.add(prize);
    }

    public BigDecimal value() {
        return totalPrize;
    }
}
