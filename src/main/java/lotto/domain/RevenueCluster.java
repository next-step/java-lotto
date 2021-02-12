package lotto.domain;

import java.util.Map;

public class RevenueCluster {

    private final Map<Revenue, Integer> revenueCluster;

    public RevenueCluster(Map<Revenue, Integer> revenueCluster){
        this.revenueCluster = revenueCluster;
    }

    public Map<Revenue, Integer> getRevenueCluster() {
        return revenueCluster;
    }

    public int calculateTotalPrize() {
        int totalRevenue = revenueCluster.entrySet().stream()
            .mapToInt(
                entry -> entry.getKey()
                    .totalRevenue(
                        entry.getValue()
                    )
            )
            .sum();
        return totalRevenue;
    }
}
