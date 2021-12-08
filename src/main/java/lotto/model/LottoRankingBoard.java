package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class LottoRankingBoard {

    public EnumMap<Rank, Integer> getLottoRankings(List<Lotto> lottoList, Lotto winningLotto) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        LottoNumbers winningNumbers = winningLotto.getLottoNumbers();
        lottoList.forEach((Lotto lotto) -> {
            Rank lottoRank = lotto.getLottoRank(winningNumbers);
            result.merge(lottoRank, 1, (rank, count) -> result.get(lottoRank) + 1);
        });
        return result;
    }
}
