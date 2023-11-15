package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<LottoRank> DISPLAY_LOTTO_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    private final Map<Integer, List<Lotto>> lottos;

    public Lottos(Map<Integer, List<Lotto>> lottos) {
        this.lottos = new HashMap<>(lottos);
    }

    public LottoResult winCounts(LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        Map<LottoRank, Long> lottoRanks = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : DISPLAY_LOTTO_RANKS) {
            lottoRanks.put(lottoRank, 0L);
        }

        lottos.values().stream()
                .flatMap(List::stream)
                .forEach(lotto -> {
                    LottoRank rank = lotto.matchCount(lottoWinNumbers, bonusBall);
                    lottoRanks.merge(rank, 1L, Long::sum);
                });
        return new LottoResult(lottoRanks);
    }

    public Map<Integer, List<Lotto>> getLottos() {
        return Collections.unmodifiableMap(lottos);
    }
}
