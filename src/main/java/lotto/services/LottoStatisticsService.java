package lotto.services;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.enums.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStatisticsService {

    public List<LottoStatistics> getLottoStatistics(List<Lotto> lottos, String winningNumber) {
        Map<Rank, LottoStatistics> lottoStatisticsByRank = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> lottoStatisticsByRank.put(rank, LottoStatistics.of(rank)));

        lottos.forEach(lotto -> {
            int equalCount = getEqualCount(lotto, winningNumber);
            Rank rank = Rank.of(equalCount);
            lottoStatisticsByRank.get(rank).addCount();
        });

        return new ArrayList<>(lottoStatisticsByRank.values());
    }

    public int getEqualCount(Lotto lotto, String winningNumber) {
        List<Integer> splitNumbers = Arrays.stream(winningNumber.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
        splitNumbers.retainAll(lotto.getNumbers());

        return splitNumbers.size();
    }

    public float getRevenueRatio(List<LottoStatistics> lottoStatistics, int payment) {
        long totalAmount = lottoStatistics.stream()
                .filter(statistics -> statistics.getCount() > 0)
                .map(statistics -> statistics.getRank().getAmount())
                .mapToLong(Long::longValue)
                .sum();

        return totalAmount / (payment / 1000f * 1000);
    }

}
