package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class LottoMatchLogic {

    private Lottos lottos;

    public LottoMatchLogic(Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoRanks checkRank(Lotto winningNumber, Fee fee) {
        return new LottoRanks(checkRankNumberMatch(winningNumber),fee);
    }

    private List<LottoRank> checkRankNumberMatch(Lotto winningNumber) {
        return lottos.getValue().stream()
                .map(lotto -> getRank(winningNumber, lotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static LottoRank getRank(Lotto winningNumber, Lotto lotto) {
        return LottoRank.valueOfMatchCount(
            lotto.getMatchNumberCount(winningNumber)
        );
    }


}
