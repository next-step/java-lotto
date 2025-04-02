package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRound {
    private final LottoNumbers winnerNumbers;

    public LottoRound(Set<Integer> winnerNumbers) {
        this.winnerNumbers = new LottoNumbers(winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet())
        );
    }

    public LottoRank checkLottoRank(LottoNumbers lottoNumbers) {
        return LottoRank.valueOfMatchCount(winnerNumbers.intersectCount(lottoNumbers));
    }

    public LottoResult checkLottoRank(List<LottoNumbers> lottoNumbers) {
        return new LottoResult(lottoNumbers.stream()
                .map(this::checkLottoRank)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), lottoNumber -> 1, Integer::sum))
        );
    }
}
