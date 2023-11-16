package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<LottoRank> DISPLAY_LOTTO_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoResult winCounts(LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        Map<LottoRank, Long> lottoRanks = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : DISPLAY_LOTTO_RANKS) {
            lottoRanks.put(lottoRank, 0L);
        }

        lottos.forEach(lotto -> {
                    LottoRank rank = lotto.matchCount(lottoWinNumbers, bonusBall);
                    lottoRanks.merge(rank, 1L, Long::sum);
                });
        return new LottoResult(lottoRanks);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
