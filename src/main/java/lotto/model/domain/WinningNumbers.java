package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class WinningNumbers {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusBall) {
        validate(winningNumbers, bonusBall);

        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
        this.bonusBall = LottoNumber.of(bonusBall);
    }

    private void validate(final List<Integer> winningNumbers, final int bonusBall) {
        validateSize(winningNumbers);
        validateDistinction(winningNumbers);
        validateDistinctionWithBonusBall(winningNumbers, bonusBall);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호를 가져야합니다.");
        }
    }

    private void validateDistinction(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Lotto.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateDistinctionWithBonusBall(final List<Integer> numbers,
            final int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복될 수 없습니다.");
        }
    }

    public LottoNumber getBonusBall() {
        return this.bonusBall;
    }

    public boolean hasNumber(final LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
