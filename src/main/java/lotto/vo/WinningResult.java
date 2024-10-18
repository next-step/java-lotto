package lotto.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class WinningResult {
    private final List<Winning> winnings;
    private final BigDecimal totalReturn;

    public WinningResult(final List<Winning> winnings, final BigDecimal totalReturn) {
        this.winnings = winnings;
        this.totalReturn = totalReturn;
    }

    public List<Winning> getWinnings() {
        return winnings;
    }

    public BigDecimal getTotalReturn() {
        return totalReturn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningResult that = (WinningResult) o;
        return Objects.equals(winnings, that.winnings) && Objects.equals(totalReturn, that.totalReturn);
    }
}
