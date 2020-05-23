package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumberResult {
    private final List<Integer> lottoNumber;

    public LottoNumberResult(List<Integer> lottoNumber) {
        this.lottoNumber = Collections.unmodifiableList(lottoNumber);
    }

    private int calculateMatchCount(List<Integer> winnerNumbers) {
        return (int) winnerNumbers.stream()
                .filter(winnerNumber -> lottoNumber.contains(winnerNumber))
                .count();
    }

    public LottoMatcher findLottoMatchResult(List<Integer> winnerNumbers) {
        this.validateWinnerNumbers(winnerNumbers);
        int matchCount = this.calculateMatchCount(winnerNumbers);
        return LottoMatcher.findRanking(matchCount);
    }

    private void validateWinnerNumbers(List<Integer> winnerNumbers) {
        if (Objects.isNull(winnerNumbers)) {
            throw new IllegalArgumentException();
        }

        if (winnerNumbers.size() != LottoNumbers.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return lottoNumber.toString();
    }
}
