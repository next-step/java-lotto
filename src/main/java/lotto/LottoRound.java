package lotto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRound {
    private final LottoNumber winnerNumbers;

    public LottoRound(Set<Integer> winnerNumbers) {
        this.winnerNumbers = new LottoNumber(winnerNumbers);
    }

    public LottoRound(LottoNumber winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public LottoRank checkLottoRank(LottoNumber lottoNumber) {
        return LottoRank.valueOfMatchCount(winnerNumbers.intersectCount(lottoNumber));
    }

    public Map<LottoRank, Integer> checkLottoRank(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(this::checkLottoRank)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), lottoNumber -> 1, Integer::sum));
    }
}
