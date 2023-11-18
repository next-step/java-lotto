package study.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

import static study.step2.domain.LottoNumber.validateNumbers;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.winningNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.stream()
            .anyMatch(winningNumber -> winningNumber.equals(number));
    }
}
