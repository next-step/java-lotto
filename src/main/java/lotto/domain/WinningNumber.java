package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> winningNumbers;

    public WinningNumber(List<LottoNumber> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
    }

    public int matchNumberCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void validate(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨번호는 null 또는 빈 값이 될 수 없습니다.");
        }
    }
}
