package lotto;

import java.util.List;
import java.util.stream.Collectors;

public final class WinningNumbers {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusBall) {
        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
        this.bonusBall = LottoNumber.of(bonusBall);
    }
}
