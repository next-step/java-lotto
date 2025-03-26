package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultAnalyzer {
    public static Map<Rank, Integer> generateStatistics(Customer customer) {
        return analyzeLottosStatistics(customer.getLottos());
    }

    public static double getROI(Customer customer) {
        List<Lotto> lottoList = customer.getLottos().getLottoList();

        double totalPrize = lottoList.stream()
                .mapToInt(Lotto::getPrize)
                .sum();

        return totalPrize / customer.getPurchaseAmount();
    }

    public static Map<Rank, Integer> analyzeLottosStatistics(Lottos lottos) {
        Map<Rank, Integer> statistics = new HashMap<>();
        initializeStatistics(statistics);

        for (Lotto lotto : lottos.getLottoList()) {
            Rank rank = lotto.getRank();
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private static void initializeStatistics(Map<Rank, Integer> statistics) {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }
}
