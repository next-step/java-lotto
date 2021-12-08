package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class LottoRankingBoard {

    public EnumMap<Rank, Integer> getLottoRankings(List<Lotto> lottoList, LottoNumbers winningNumbers) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        lottoList.forEach((Lotto lotto) -> {
            Rank lottoRank = lotto.getLottoRank(winningNumbers);
            result.merge(lottoRank, 1, (rank, count) -> result.get(lottoRank) + 1);
        });
        return result;
    }
}
