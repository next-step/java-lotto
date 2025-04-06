package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRound {
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoRound(Set<Integer> winnerNumbers, Integer bonusNumber) {
        this.winnerNumbers = new LottoNumbers(winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet())
        );
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoRank checkLottoRank(LottoNumbers lottoNumbers) {
        return LottoRank.valueOfMatchCount(winnerNumbers.intersectCount(lottoNumbers, bonusNumber));
    }

    public LottoResult checkLottoRank(List<LottoNumbers> lottoNumbers) {
        return new LottoResult(lottoNumbers.stream()
                .map(this::checkLottoRank)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), lottoNumber -> 1, Integer::sum))
        );
    }
}
