package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoWinnerNumber {
    private final List<Lotto> winnerNumbers;
    private final Lotto bonusBall;

    public LottoWinnerNumber(List<Lotto> winnerNumbers, Lotto bonusBall) {
        this.validateWinnerNumbers(winnerNumbers);
        this.validateOverlapNumber(winnerNumbers, bonusBall);
        this.winnerNumbers = Collections.unmodifiableList(winnerNumbers);
        this.bonusBall = bonusBall;
    }

    private void validateWinnerNumbers(List<Lotto> winnerNumbers) {
        if (Objects.isNull(winnerNumbers)) {
            throw new IllegalArgumentException();
        }

        if (winnerNumbers.size() < LottoNumbers.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlapNumber(List<Lotto> winnerNumbers, Lotto bonusBall) {
        boolean overlapNumber = winnerNumbers.stream()
                .filter(lotto -> lotto.getNumber() == bonusBall.getNumber())
                .findFirst()
                .isPresent();

        if (overlapNumber) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getWinnerNumbers() {
        return this.winnerNumbers;
    }

    public Lotto getBonusBall() {
        return this.bonusBall;
    }

    public boolean isValidWinnerNumber(int size) {
        return this.winnerNumbers == null || this.winnerNumbers.size() != size ? false : true;
    }
}
