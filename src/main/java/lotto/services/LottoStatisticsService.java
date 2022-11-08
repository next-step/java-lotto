package lotto.services;

import lotto.models.IssuedLotto;
import lotto.models.LottoStatistics;
import lotto.models.WinningLotto;
import lotto.models.enums.Rank;
import lotto.models.request.IssueLottoRequest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatisticsService {

    public List<LottoStatistics> getLottoStatistics(List<IssuedLotto> issuedLottos, WinningLotto winningLotto) {
        Map<Rank, LottoStatistics> lottoStatisticsByRank = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(Function.identity(), LottoStatistics::of));

        issuedLottos.forEach(issuedLotto -> {
            Rank rank = Rank.findRank(winningLotto, issuedLotto);
            lottoStatisticsByRank.get(rank).addCount();
        });

        return new ArrayList<>(lottoStatisticsByRank.values());
    }

    public float getRevenueRatio(List<LottoStatistics> lottoStatistics, IssueLottoRequest issueLottoRequest) {
        long totalAmount = lottoStatistics.stream()
                .filter(statistics -> statistics.getCount() > 0)
                .map(statistics -> statistics.getRank().getAmount())
                .mapToLong(Long::longValue)
                .sum();

        return calculateRevenueRatio(issueLottoRequest.getPayment(), totalAmount);
    }

    private float calculateRevenueRatio(int payment, long totalAmount) {
        return totalAmount / (payment / 1000f * 1000);
    }

}
