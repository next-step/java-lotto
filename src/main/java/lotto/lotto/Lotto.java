package lotto.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.error.ErrorMessage;
import lotto.ui.InputView;

public class Lotto {
    public static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumber(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public int matchingCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber.numbers()::contains)
                .count();
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    public boolean isContainBonus(LottoNumber bonusNumber) {
        return numbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private void checkNumber(List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }
}
