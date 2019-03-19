package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoCalculator {
    public static Map<Rank, Long> makeRankGroup(List<Rank> ranks) {
        return ranks.stream()
            .collect(Collectors.groupingBy(r -> r, Collectors.counting()));
    }


    public static Double calculateProfitRate(List<Rank> ranks) {
        return calculatePrizeMoney(ranks).doubleValue() /
            (LottoMachine.LOTTO_PRICE * ranks.size());
    }

    public static Long calculatePrizeMoney(List<Rank> ranks) {
        return ranks.stream()
            .mapToLong(Rank::getPrizeMoney)
            .sum();
    }
}
