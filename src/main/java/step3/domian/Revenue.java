package step3.domian;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Revenue {

    private final int revenue;

    public Revenue(LottoResult results) {
        this.revenue = Arrays
                .stream(Prize.values())
                .map(it -> it.prizeMoney * results.getResultCount(it))
                .mapToInt(it -> it.intValue())
                .sum();
    }

    public double calculatePercentage(int lottoPrice) {
        return (double) this.revenue / (double) lottoPrice;
    }
}
