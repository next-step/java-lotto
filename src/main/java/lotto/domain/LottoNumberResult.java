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

    private boolean isAdjustBonusBall(Lotto bonusBall) {
        return lotto.stream()
                .filter(lottoNumber -> lottoNumber.equals(bonusBall))
                .findFirst().isPresent();
    }

    public LottoMatcher findLottoMatchResult(LottoWinnerNumber lottoWinnerNumber) {
        this.validateWinnerNumbers(lottoWinnerNumber);
        int matchCount = this.calculateMatchCount(lottoWinnerNumber.getWinnerNumbers());
        boolean adjustBonusBall = this.isAdjustBonusBall(lottoWinnerNumber.getBonusBall());
        return LottoMatcher.findRanking(matchCount, adjustBonusBall);
    }

    private void validateWinnerNumbers(LottoWinnerNumber lottoWinnerNumber) {
        if (Objects.isNull(lottoWinnerNumber)) {
            throw new IllegalArgumentException();
        }

        if (lottoWinnerNumber.isValidWinnerNumber(LottoNumbers.LOTTO_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return lotto.toString();
    }
}
