package step4.domain;

import java.util.Arrays;

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
