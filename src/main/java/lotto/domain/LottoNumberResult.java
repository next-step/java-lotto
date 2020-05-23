package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumberResult {
    private final List<Lotto> lotto;

    public LottoNumberResult(List<Lotto> lotto) {
        this.lotto = Collections.unmodifiableList(lotto);
    }

    private int calculateMatchCount(List<Lotto> winnerNumbers) {
        return (int) winnerNumbers.stream()
                .filter(winnerNumber -> lotto.contains(winnerNumber))
                .count();
    }

    public LottoMatcher findLottoMatchResult(List<Lotto> winnerNumbers) {
        this.validateWinnerNumbers(winnerNumbers);
        int matchCount = this.calculateMatchCount(winnerNumbers);
        return LottoMatcher.findRanking(matchCount);
    }

    private void validateWinnerNumbers(List<Lotto> winnerNumbers) {
        if (Objects.isNull(winnerNumbers)) {
            throw new IllegalArgumentException();
        }

        if (winnerNumbers.size() != LottoNumbers.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return lotto.toString();
    }
}
