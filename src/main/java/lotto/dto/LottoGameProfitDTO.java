package lotto.dto;

import java.util.Objects;

public class LottoGameProfitDTO {
    private double profit;

    public LottoGameProfitDTO(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameProfitDTO that = (LottoGameProfitDTO) o;
        return Double.compare(that.profit, profit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }
}
