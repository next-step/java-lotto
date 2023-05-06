package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatics {
    private static final int REVENUE_START = 0;
    private static final int MAP_DEFAULT = 0;

    private int cost;
    private Map<Integer, Integer> statics;

    public LottoStatics(int cost, List<Integer> result) {
        this.cost = cost;
        this.statics = createStatics(result);
    }

    public Map<Integer, Integer> getStatics() {
        return statics;
    }

    private Map<Integer, Integer> createStatics(List<Integer> result) {
        return result.stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }

    public String getRate() {
        float revenue = REVENUE_START;
        for(int matchNumber: Rank.getCountList()) {
            revenue += (statics.getOrDefault(matchNumber, MAP_DEFAULT) * Rank.of(matchNumber));
        }

        return String.valueOf(Math.floor((revenue / (float)cost) * 100) / 100.0);
    }
}
