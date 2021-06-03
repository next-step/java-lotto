package study.lotto.domain;

import java.math.BigDecimal;

public class TotalPrize {
    private final BigDecimal totalPrize;

    public TotalPrize(BigDecimal totalPrize) {
        this.totalPrize = totalPrize;
    }

    public TotalPrize add(BigDecimal prize) {
        return new TotalPrize(totalPrize.add(prize));
    }

    public BigDecimal value() {
        return totalPrize;
    }
}
