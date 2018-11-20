package lotto;

import lotto.domain.LottoDto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Rank.values;

public abstract class LottoResult {

    private LottoResult() {
    }

    public static Lottos rankOfMatch(final LottoDto lottoDto, final Rank rank) {
        return new Lottos(
                lottoDto.getLottos()
                        .stream()
                        .filter(lotto -> lotto.lottoOfRank(lottoDto.getLotto(), rank, lottoDto.getBonus()))
                        .collect(toList()));
    }

    public static Map<Rank, Lottos> calculateLottoResult(final LottoDto lottoDto) {
        final Map<Rank, Lottos> result = new HashMap<>();
        for (Rank rank : values()) {
            if (rankMissIsContinue(rank)) continue;
            result.put(rank, rankOfMatch(lottoDto, rank));
        }
        return result;
    }

    private static boolean rankMissIsContinue(final Rank rank) {
        return rank.equals(Rank.MISS);
    }

}
