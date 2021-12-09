package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankingBoard {

    public Map<Rank, Integer> getLottoRankings(List<Lotto> lottoList, Lotto winningLotto) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        LottoNumbers winningNumbers = winningLotto.getLottoNumbers();
        lottoList.forEach((Lotto lotto) -> {
            Rank lottoRank = lotto.getLottoRank(winningNumbers);
            result.merge(lottoRank, 1, (rank, count) -> result.get(lottoRank) + 1);
        });
        return result;
    }

    public long getTotalReward(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong((Map.Entry<Rank, Integer> entry) -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
