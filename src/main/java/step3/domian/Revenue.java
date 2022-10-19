package step3.domian;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Revenue {

    private final int revenue;

    public Revenue(LottoResult results) {
        this.revenue = Arrays.stream(Prize.values()).map(it -> it.prizeMoney * results.getResultCount(it)).mapToInt(it -> it.intValue()).sum();
    }

    public Revenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue1 = (Revenue) o;
        return revenue == revenue1.revenue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    public double calculatePercentage(int lottoPrice) {
        return (double) this.revenue / (double) lottoPrice;
    }
}
